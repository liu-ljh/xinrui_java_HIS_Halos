package org.xinrui.wuchuang.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xinrui.common.mapper.BloodFilmManagementMapper;
import org.xinrui.common.mapper.ExaminationInfoMapper;
import org.xinrui.common.mapper.PatientInfoMapper;
import org.xinrui.common.mapper.SampleInfoMapper;
import org.xinrui.wuchuang.dto.SampleDto;
import org.xinrui.wuchuang.dto.SampleRegistrationDto;
import org.xinrui.common.entity.ExaminationInfo;
import org.xinrui.common.entity.PatientInfo;
import org.xinrui.common.entity.SampleInfo;
import org.xinrui.common.exception.BusinessException;
import org.xinrui.wuchuang.mapper.*;
import org.xinrui.wuchuang.service.SampleService;
import org.xinrui.common.util.ConvertUtil;
import org.xinrui.wuchuang.util.SampleUtil;
import org.xinrui.wuchuang.util.sample.*;

import java.time.LocalDate;

@Slf4j
@Service("WuchuangSampleService")
public class SampleServiceImpl implements SampleService {

    @Autowired
    @Qualifier("WuchuangSampleMapper")
    private SampleMapper sampleMapper;

    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    private SampleInfoMapper sampleInfoMapper;

    @Autowired
    private ExaminationInfoMapper examinationInfoMapper;

    @Autowired
    private BloodFilmManagementMapper bloodFilmManagementMapper;


    @Override
    @Transactional(readOnly = true)
    public SampleDto getSample(String oldSampleNum) {
        log.info("查询样本信息，原样本编号: {}", oldSampleNum);

        // 1. 查询数据库（优先使用唯一索引字段）
        SampleDto sampleDto = sampleMapper.selectByOldSampleNum(oldSampleNum);
        if (sampleDto == null) {
            log.warn("样本信息不存在，原样本编号: {}", oldSampleNum);
            throw new BusinessException("100110103", "请求的资源不存在");
        }

        //2.属性的校验，确保部分字段的必填以及数值的规定
        SampleUtil.RequestSampleValidate(sampleDto);

        log.info("样本信息查询成功，样本编号: {}", sampleDto.getSampleId());
        return sampleDto;
    }

    @Override
    @Transactional
    public boolean handleSampleRegistrationInfo(SampleRegistrationDto sampleRegistrationDto) {
        log.info("样本登记信息处理，样本编号为: {}", sampleRegistrationDto.getSampleId());
        PatientInfo patientInfo = handlePatientInfo(sampleRegistrationDto);
        SampleInfo sampleInfo = handleSampleInfo(sampleRegistrationDto, patientInfo.getOid());
        handleExaminationInfo(sampleRegistrationDto, sampleInfo.getOid());
        return true;
    }

    @Override
    @Transactional
    public PatientInfo handlePatientInfo(SampleRegistrationDto sampleRegistrationDto) {
        // 1. 根据证件号或手机号查询患者信息
        PatientInfo patientInfo = patientInfoMapper.selectOne(
                Wrappers.<PatientInfo>lambdaQuery()
                        .or(query -> query.eq(PatientInfo::getIdentity, sampleRegistrationDto.getIdentity()))
                        .or(query -> query.eq(PatientInfo::getPhone, sampleRegistrationDto.getPhone()))
        );

        if (patientInfo == null) {
            // 2. 如果不存在，则创建新患者
            patientInfo = BuildUtil.buildPatientInfo(sampleRegistrationDto);
            patientInfoMapper.insert(patientInfo);
        } else {
            // 3. 如果存在，则更新患者信息
            UpdateUtil.updatePatientInfo(patientInfo, sampleRegistrationDto);
            patientInfoMapper.updateById(patientInfo);
        }

        return patientInfo;
    }

    @Override
    @Transactional
    public SampleInfo handleSampleInfo(SampleRegistrationDto sampleRegistrationDto, Long patientOid) {
        // 1. 根据样本编号查询样本信息
        SampleInfo sampleInfo = sampleInfoMapper.selectOne(
                Wrappers.<SampleInfo>lambdaQuery()
                        .eq(SampleInfo::getSampleId, sampleRegistrationDto.getSampleId())
        );

        if (sampleInfo == null) {
            // 2. 如果不存在，则创建新样本
            sampleInfo = BuildUtil.buildSampleInfo(sampleRegistrationDto, patientOid);
            //获取采样时间
            LocalDate collectDate = sampleMapper.selectCollectDateBySAId(sampleInfo.getScreeningArchivesId());
            sampleInfo.setCollectDate(ConvertUtil.convertDateTime(collectDate.toString()));
            sampleInfo.setReceivedDate(ConvertUtil.convertDateTime(collectDate.toString()));
            sampleInfoMapper.insert(sampleInfo);
        } else {
            // 3. 如果存在，则更新样本信息
            UpdateUtil.updateSampleInfo(sampleInfo, sampleRegistrationDto, patientOid);

            sampleInfoMapper.updateById(sampleInfo);
        }

        return sampleInfo;
    }

    @Override
    @Transactional
    public void handleExaminationInfo(SampleRegistrationDto sampleRegistrationDto, Long sampleOid) {
        // 1. 根据sample_oid查询检查信息
        ExaminationInfo exam = examinationInfoMapper.selectOne(
                Wrappers.<ExaminationInfo>lambdaQuery()
                        .eq(ExaminationInfo::getSampleOid, sampleOid)
        );

        if (exam == null) {
            // 2. 如果不存在，则创建新检查信息
            exam = BuildUtil.buildExaminationInfo(sampleRegistrationDto, sampleOid);
            examinationInfoMapper.insert(exam);
        } else {
            // 3. 如果存在，则更新检查信息
            UpdateUtil.updateExaminationInfo(exam, sampleRegistrationDto, sampleOid);
            examinationInfoMapper.updateById(exam);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public SampleRegistrationDto getSampleRegistrationBySAId(Long screeningArchivesId) {
        if (screeningArchivesId == null) {
            log.warn("筛查档案 ID 不能为空");
            throw new BusinessException("-1", "screeningArchivesId 不能为空");
        }

        // 直接使用多表联查获取数据
        SampleRegistrationDto dto = sampleMapper.selectSampleRegistrationBySAId(screeningArchivesId);

        if (dto == null || dto.getSampleId() == null) {
            log.warn("未找到对应的实验编号，screeningArchivesId: {}", screeningArchivesId);
            throw new BusinessException("-1", "请检查 screeningArchivesId 是否正确");
        }

        String pregnancy = dto.getPregnancy();
        if ("1".equals(pregnancy)) {
            dto.setPregnancy("单胎");
        } else {
            dto.setPregnancy((pregnancy == null || "".equals(pregnancy)) ? "" : "双胎或多胎");
        }

        log.info("样本登记信息查询成功，样本编号：{}", dto.getSampleId());
        return dto;
    }


}
