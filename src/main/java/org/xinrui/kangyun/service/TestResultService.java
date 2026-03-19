package org.xinrui.kangyun.service;

import org.springframework.stereotype.Service;
import org.xinrui.common.entity.PatientInfo;
import org.xinrui.common.entity.SampleInfo;
import org.xinrui.kangyun.dto.testResult.TestResultDto;


public interface TestResultService {

    boolean handlePushResult(TestResultDto requestDTO);

}
