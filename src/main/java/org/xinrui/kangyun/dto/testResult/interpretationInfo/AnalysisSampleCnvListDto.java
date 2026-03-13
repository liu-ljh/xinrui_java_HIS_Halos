package org.xinrui.kangyun.dto.testResult.interpretationInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AnalysisSampleCnvListDto {

    @ApiModelProperty("染色体号")
    private String chr;

    @ApiModelProperty("起始位置")
    private String cnvStart;

    @ApiModelProperty("终止位置")
    private String cnvEnd;

    @ApiModelProperty("变异")
    private String variantInfo;

    @ApiModelProperty("变异类型")
    private String variantType;

    @ApiModelProperty("变异分类")
    private String svType;

    @ApiModelProperty("片段大小")
    private String length;

    @ApiModelProperty("位置(GRCh37)")
    private String location;

    @ApiModelProperty("Copy_ratio")
    private String copyRatio;

    @ApiModelProperty("嵌合度")
    private String mosaicReport;

    @ApiModelProperty("拷贝数")
    private BigDecimal copyNumReport;

    @ApiModelProperty("致病性_自动")
    private String pathogenicity;

    @ApiModelProperty("致病性_报告")
    private String pathogenicityReport;

    @ApiModelProperty(value = "BGI-Inhouse数据库（0：否，1：是）")
    private Integer bgiInhouse;

    @ApiModelProperty("证据项_自动")
    private String autoEvidence;

    @ApiModelProperty("结果说明_自动")
    private String interpretation;

    @ApiModelProperty("结果说明_报告")
    private String interpretationReport;

    @ApiModelProperty("文献_自动")
    private String hgmdReference;

    @ApiModelProperty("文献_报告")
    private String hgmdReferenceReport;

    @ApiModelProperty(value = "是否报告（0：否，1：是）")
    private Integer reportFlag;

    @ApiModelProperty("备注")
    private String remark;
}
