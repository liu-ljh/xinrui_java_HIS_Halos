package org.xinrui.kangyun.dto.testResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnalysisInfoDto {

    @ApiModelProperty(value = "样本质控结果（1：通过、2：不通过）")
    private Integer sampleQcResult;

    @ApiModelProperty("质控失败原因")
    private String sampleQcReason;

    @ApiModelProperty("GC(unique)(%)")
    private String uniqueGc;

    @ApiModelProperty("CV")
    private String cv;

    @ApiModelProperty("Unique_Reads(M)")
    private String uniqueReads;

    @ApiModelProperty("Duplication(%)")
    private String duplicateRate;

    @ApiModelProperty("Map_Rate(%)")
    private String mapRate;

    @ApiModelProperty("Q30(%)")
    private String q30;
}
