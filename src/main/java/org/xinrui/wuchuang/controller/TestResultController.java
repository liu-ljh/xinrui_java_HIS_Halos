package org.xinrui.wuchuang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xinrui.common.dto.ApiResponse;
import org.xinrui.wuchuang.dto.testResult.TestResultDto;
import org.xinrui.wuchuang.service.TestReportFileService;
import org.xinrui.wuchuang.service.TestResultService;

import javax.validation.Valid;


/**
 * Halos推送结果数据控制器
 * 用于处理结果推送相关的HTTP请求
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/his/V3/result")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private TestReportFileService testReportFileService;

    /**
     * Halos推送JSON结果数据接口
     * POST /his/V3/sample/pushResult
     */
    @PostMapping("/pushResult")
    public ApiResponse<Void> pushResult(@Valid @RequestBody TestResultDto requestDTO) {
            log.info("接收JSON结果数据");
            boolean success = testResultService.handlePushResult(requestDTO);
            return success ?
                    ApiResponse.success() : // 调用无参 success
                    ApiResponse.fail("请求失败");


    }


    /**
     * 接收 Halos 推送的报告文件（multipart/form-data）
     * POST /his/V3/result/pushReport
     *
     * 约定：
     * 1. Content-Type: multipart/form-data
     * 2. 文件字段名：file
     * 3. 文件名由 Halos 系统通过"报告命名"功能生成，HIS 通过文件名匹配样本
     * 4. 支持 PDF 和 WORD 格式，自动根据文件扩展名识别
     */
    @PostMapping(path = "/pushReport")
    public ApiResponse receiveReport(@RequestParam("file") MultipartFile file) {
        log.info("接收报告文件");
        boolean success = testReportFileService.receiveReport(file);
        return success ? ApiResponse.success() : ApiResponse.fail("上传失败");
    }

}
