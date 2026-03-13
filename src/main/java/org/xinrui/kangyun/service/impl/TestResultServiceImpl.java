package org.xinrui.kangyun.service.impl;

import org.springframework.stereotype.Service;
import org.xinrui.common.entity.PatientInfo;
import org.xinrui.common.entity.SampleInfo;
import org.xinrui.kangyun.dto.testResult.TestResultDto;
import org.xinrui.kangyun.service.TestResultService;

@Service
public class TestResultServiceImpl implements TestResultService {

    @Override
    public boolean handlePushResult(TestResultDto requestDTO){
        return true;
    }

    @Override
    public SampleInfo handleSampleInfo(TestResultDto dto, Long patientOid){
        return null;
    }

    @Override
    public PatientInfo handlePatientInfo(TestResultDto dto){
        return null;
    }

    @Override
    public void handleExaminationInfo(TestResultDto dto, SampleInfo sampleInfo){

    }

    @Override
    public void handleSampleQcInfo(TestResultDto dto, SampleInfo sampleInfo){

    }

    @Override
    public void handleLaneQcInfo(TestResultDto dto, SampleInfo sampleInfo){

    }

    @Override
    public Long handleTestResultInfo(TestResultDto dto, SampleInfo sampleInfo){
        return 1L;
    }

    @Override
    public void handleTestCnvInfo(TestResultDto dto, Long testResultOid){

    }
}
