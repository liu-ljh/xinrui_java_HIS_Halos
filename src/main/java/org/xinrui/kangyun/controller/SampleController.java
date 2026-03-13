package org.xinrui.kangyun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xinrui.common.dto.ApiResponse;
import org.xinrui.kangyun.service.SampleService;
import org.xinrui.kangyun.dto.SampleDto;

import javax.validation.constraints.NotBlank;

@RestController
@Slf4j
@Validated
@RequestMapping("/his/V3/kangyun/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/get/{oldSampleNum}")
    public ApiResponse<SampleDto> getSampleInfo(
            @PathVariable @NotBlank(message = "原样本编号不能为空") String oldSampleNum) {
        SampleDto result = sampleService.getSample(oldSampleNum);
        return ApiResponse.success(result);

    }
}
