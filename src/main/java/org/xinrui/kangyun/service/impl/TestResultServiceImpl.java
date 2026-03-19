package org.xinrui.kangyun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xinrui.common.entity.PatientInfo;
import org.xinrui.common.entity.SampleInfo;
import org.xinrui.common.entity.TestCnvInfo;
import org.xinrui.common.entity.TestResultInfo;
import org.xinrui.common.exception.BusinessException;
import org.xinrui.common.mapper.SampleInfoMapper;
import org.xinrui.common.mapper.TestCnvInfoMapper;
import org.xinrui.common.mapper.TestResultInfoMapper;
import org.xinrui.kangyun.dto.testResult.TestResultDto;
import org.xinrui.kangyun.service.TestResultService;
import org.xinrui.kangyun.util.testResult.Convert;

import java.util.List;

@Slf4j
@Service("KangyunTestResultService")
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private SampleInfoMapper sampleInfoMapper;

    @Autowired
    private TestResultInfoMapper testResultInfoMapper;

    @Autowired
    private TestCnvInfoMapper testCnvInfoMapper;

    @Override
    public boolean handlePushResult(TestResultDto requestDTO){
        // 1. 提取样本编号
        String sampleId = requestDTO.getSampleNo();
        if (sampleId == null || sampleId.isEmpty()) {
            return false; // 样本编号为空
        }

        // 2. 查询t_lis_sample表
        SampleInfo sampleInfo = sampleInfoMapper.selectOne(new QueryWrapper<SampleInfo>()
                .eq("sample_id", sampleId));

        if (sampleInfo == null) {
            log.error("样本信息缺失，无法存入cnv结果,请检查t_lis_sample表");
            throw new BusinessException("-1","样本未归档，无法存入cnv结果"); // 样本未归档
        }

        // 3. 查询t_lis_test_result表
        TestResultInfo testResultInfo = testResultInfoMapper.selectOne(new QueryWrapper<TestResultInfo>()
                .eq("sample_oid", sampleInfo.getOid()));

        if (testResultInfo == null) {
            log.error("检测结果未创建，无法存入cnv结果,请检查t_lis_test_result表");
            throw new BusinessException("-1","样本报告信息缺失，无法存入cnv结果"); // 检测结果未创建
        }

        // 4. 查询t_lis_test_cnv表
        List<TestCnvInfo> cnvList = testCnvInfoMapper.selectList(new QueryWrapper<TestCnvInfo>()
                .eq("result_oid", testResultInfo.getOid()));

        // 5. 处理CNV数据
        String rawData = Convert.convertToJSON(requestDTO); // 转换DTO为JSON字符串
        TestCnvInfo cnvInfo = new TestCnvInfo();
        cnvInfo.setResultOid(testResultInfo.getOid());
        cnvInfo.setResultRawData(rawData); // 存储原始数据

        if (cnvList != null && !cnvList.isEmpty()) {
            // 使用条件更新，更新所有符合条件的记录
            TestCnvInfo updateEntity = new TestCnvInfo();
            updateEntity.setResultRawData(rawData);
            UpdateWrapper<TestCnvInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("result_oid", testResultInfo.getOid());

            testCnvInfoMapper.update(updateEntity, updateWrapper);
        } else {
            // 新增逻辑
            cnvInfo.setCnvCategory("K");
            testCnvInfoMapper.insert(cnvInfo);
        }
        return true;
    }


}
