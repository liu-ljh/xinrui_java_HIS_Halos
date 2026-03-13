package org.xinrui.kangyun.dto.testResult.interpretationInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnalysisSampleVirusListDto {

    @ApiModelProperty("病原")
    private String pathogenCn;

    @ApiModelProperty("病原_EN")
    private String pathogenEn;

    @ApiModelProperty("病原_高通量结果")
    private String readsAndFraction;

    @ApiModelProperty(value = "是否验证（0: 否；1: 待验证；2: 已验证）")
    private Integer validated;

    @ApiModelProperty("验证结果")
    private String validateResult;

    @ApiModelProperty("验证结果_病毒载量")
    private String viralLoad;

    @ApiModelProperty("备注")
    private String remark;
}
