package org.xinrui.kangyun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xinrui.common.dto.ApiResponse;
import org.xinrui.kangyun.service.SampleService;
import org.xinrui.kangyun.dto.SampleDto;

import javax.validation.constraints.NotBlank;

@RestController("KangyunSampleController")
@Slf4j
@Validated
@RequestMapping("/his/V3/kangyun/sample")
public class SampleController {

    @Autowired
    @Qualifier("KangyunSampleService")
    private SampleService sampleService;

    @GetMapping("/get/{oldSampleNum}")
    public ApiResponse<SampleDto> getSampleInfo(
            @PathVariable @NotBlank(message = "原样本编号不能为空") String oldSampleNum) {
        SampleDto result = sampleService.getSample(oldSampleNum);
        return ApiResponse.success(result);

    }

    //测试使用
    @PostMapping("/test")
    public ApiResponse test(@RequestBody String body) {
        log.info("body:{}", body);
        return ApiResponse.success();
    }
}
