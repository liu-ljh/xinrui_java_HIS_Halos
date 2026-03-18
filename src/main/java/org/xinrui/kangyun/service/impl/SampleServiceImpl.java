package org.xinrui.kangyun.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xinrui.common.exception.BusinessException;
import org.xinrui.kangyun.*;
import org.xinrui.kangyun.dto.SampleDto;
import org.xinrui.kangyun.mapper.SampleMapper;
import org.xinrui.kangyun.service.SampleService;
import org.xinrui.kangyun.util.SampleUtil;

import java.time.LocalDateTime;

@Slf4j
@Service("KangyunSampleService")
public class SampleServiceImpl implements SampleService {

    private static final Long UPDATED_BY = 1L; // 固定更新人ID

    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public SampleDto getSample(String oldSampleNum) {
        // 1. 查询数据库（优先使用唯一索引字段）
        SampleDto sampleDto = sampleMapper.selectByOldSampleNum(oldSampleNum);
        if (sampleDto == null) {
            log.warn("样本信息不存在，原样本编号: {}", oldSampleNum);
            throw new BusinessException("-1", "请求的资源不存在");
        }

        //2.属性的校验，确保部分字段的必填以及数值的规定
        SampleUtil.RequestSampleValidate(sampleDto);

        //3.对一些字段进行转换
        //查出来的borrowOvumFlag需要重新转换，此时01-自体供卵，02-异体供卵，需要换成2-否，1-是
        if (sampleDto.getBorrowOvumFlag() == 1) {
            sampleDto.setBorrowOvumFlag(2);
        } else if(sampleDto.getBorrowOvumFlag()==2){
            sampleDto.setBorrowOvumFlag(1);
        }else{
            sampleDto.setBorrowOvumFlag(0);
        }

        //查出来的ultrasonicFlag是否做过超声检查，此时01-未见异常，02-提示异常，需要换成1是0否，有数值为是，无数值为否
        if (sampleDto.getUltrasonicFlag()!= null && sampleDto.getUltrasonicFlag()!=0){
            sampleDto.setUltrasonicFlag(1);
        }else {
            sampleDto.setUltrasonicFlag(0);
        }

        //ultrasonicAbnormalFlag超声检查是否异常，此时01-未见异常，02-提示异常，需要换成1是0否
        if(sampleDto.getUltrasonicAbnormalFlag()==1){
            sampleDto.setUltrasonicAbnormalFlag(0);
        } else if (sampleDto.getUltrasonicAbnormalFlag()==2) {
            sampleDto.setUltrasonicAbnormalFlag(1);
        }

        sampleDto.setOperator(UPDATED_BY);
        sampleDto.setOperationTime(LocalDateTime.now());

        log.info("样本信息查询成功，样本编号: {}", sampleDto.getSampleNo());
        return sampleDto;
    }
}
