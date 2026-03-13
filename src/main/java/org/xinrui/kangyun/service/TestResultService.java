package org.xinrui.kangyun.service;

import org.xinrui.common.entity.PatientInfo;
import org.xinrui.common.entity.SampleInfo;
import org.xinrui.kangyun.dto.testResult.TestResultDto;

public interface TestResultService {

    boolean handlePushResult(TestResultDto requestDTO);

    SampleInfo handleSampleInfo(TestResultDto dto, Long patientOid);

    PatientInfo handlePatientInfo(TestResultDto dto);

    void handleExaminationInfo(TestResultDto dto, SampleInfo sampleInfo);

    void handleSampleQcInfo(TestResultDto dto, SampleInfo sampleInfo);

    void handleLaneQcInfo(TestResultDto dto, SampleInfo sampleInfo);

    Long handleTestResultInfo(TestResultDto dto, SampleInfo sampleInfo);

    void handleTestCnvInfo(TestResultDto dto, Long testResultOid);
}
