package org.xinrui.kangyun.dto.testResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class TestResultDto {

    @ApiModelProperty("样本编号")
    private String sampleNo;

    @ApiModelProperty("任务编号")
    private String batchNo;

    @ApiModelProperty("样例编号")
    private String subId;

    @ApiModelProperty("子任务编号")
    private String batchSubNo;

    @ApiModelProperty("样本信息")
    private SampleInfoDto sampleInfo;

    @ApiModelProperty("任务信息")
    private TaskInfoDto taskInfo;

    @ApiModelProperty("分析信息")
    private AnalysisInfoDto analysisInfo;

    @ApiModelProperty("检测结果解析信息")
    private InterpretationInfoDto interpretationInfo;

    @ApiModelProperty("报告信息（动态键值对）")
    private Map<String, Object> reportInfo;
}
