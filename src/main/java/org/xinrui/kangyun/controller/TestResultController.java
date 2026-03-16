package org.xinrui.kangyun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xinrui.common.dto.ApiResponse;
import org.xinrui.kangyun.dto.testResult.TestResultDto;
import org.xinrui.kangyun.service.TestResultService;
import org.xinrui.kangyun.service.TestReportFileService;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController("KangyunTestResultController")
@RequestMapping("/his/V3/kangyun/result")
public class TestResultController {
    @Autowired
    @Qualifier("KangyunTestResultService")
    private TestResultService testResultService;

    @Autowired
    @Qualifier("KangyunTestReportFileService")
    private TestReportFileService testReportFileService;


    @PostMapping("/pushResult")
    public ApiResponse<Void> pushResult(@Valid @RequestBody TestResultDto requestDTO) {
        log.info("接收JSON结果数据");
        boolean success = testResultService.handlePushResult(requestDTO);
        return success ?
                ApiResponse.success() : // 调用无参 success
                ApiResponse.fail("请求失败");

    }



    @PostMapping(path = "/pushReport")
    public ApiResponse receiveReport(@RequestParam("file") MultipartFile file) {
        log.info("接收报告文件");
//        boolean success = testReportFileService.receiveReport(file);
//        return success ? ApiResponse.success() : ApiResponse.fail("上传失败");
        return ApiResponse.success();
    }
}
