package org.xinrui.wuchuang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xinrui.common.dto.ApiResponse;
import org.xinrui.wuchuang.dto.SampleDto;
import org.xinrui.wuchuang.dto.SampleRegistrationDto;
import org.xinrui.wuchuang.service.SampleService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Halos请求样本信息控制器类
 * 该类用于处理HTTP请求，并返回相应的响应结果
 */
@Slf4j
@Validated
@RestController("WuchuangSampleController")
@RequestMapping("/his/V3/wuchuang/sample")
public class SampleController {

    @Autowired
    @Qualifier("WuchuangSampleService")
    private SampleService sampleService;

    /**
     * Halos请求样本信息接口
     * GET /his/V3/sample/get/{oldSampleNum}
     */
    @GetMapping("/get/{oldSampleNum}")
    public ApiResponse<SampleDto> getSampleInfo(
            @PathVariable @NotBlank(message = "原样本编号不能为空") String oldSampleNum) {
        SampleDto result = sampleService.getSample(oldSampleNum);
        return ApiResponse.success(result);

    }

    @PostMapping("/registration/save")
    public ApiResponse saveSampleRegistrationInfo(@Valid @RequestBody SampleRegistrationDto sampleRegistrationDto) {
        log.info("接收样本登记数据");
        boolean success = sampleService.handleSampleRegistrationInfo(sampleRegistrationDto);
        return success ?
                ApiResponse.success() : // 调用无参 success
                ApiResponse.fail("请求失败");
    }

    /**
     * 根据筛查档案 ID 获取样本登记信息
     * GET /his/V3/sample/registration
     */
    @GetMapping("/registration/get")
    public ApiResponse<SampleRegistrationDto> getSampleRegistrationInfo(
            @RequestParam(required = false)Long screeningArchivesId) {
        SampleRegistrationDto result = sampleService.getSampleRegistrationBySAId(screeningArchivesId);
        return ApiResponse.success(result);
    }


}
