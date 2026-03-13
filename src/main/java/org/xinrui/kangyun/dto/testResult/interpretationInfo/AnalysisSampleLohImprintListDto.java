package org.xinrui.kangyun.dto.testResult.interpretationInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnalysisSampleLohImprintListDto {
    @ApiModelProperty("染色体")
    private String chrom;

    @ApiModelProperty("变异起始位置")
    private String start;

    @ApiModelProperty("变异结束位置")
    private String end;

    @ApiModelProperty(value = "是否印记区域（1：是；0：否）")
    private Integer imprint;

    @ApiModelProperty("片段大小")
    private String size;

    @ApiModelProperty("区段")
    private String location;

    @ApiModelProperty("UPD疾病")
    private String upd;

    @ApiModelProperty("UPD疾病位置(GRch37)")
    private String updDiseaseRegion;

    @ApiModelProperty("UPD来源")
    private String updDescription;

    @ApiModelProperty("UPD_OMIM_ID")
    private String updOmimId;

    @ApiModelProperty("临床表型")
    private String updClinical;

    @ApiModelProperty("致病性")
    private String pathogenicity;

    @ApiModelProperty("文献")
    private String pmidReference;

    @ApiModelProperty("区域内OMIM基因详情")
    private String geneLocus;

    @ApiModelProperty(value = "是否验证（0: 否,1: 待验证, 2: 已验证）")
    private Integer validated;

    @ApiModelProperty(value = "验证结果（0: 否, 1: 是）")
    private Integer lohImprintResult;

    @ApiModelProperty("备注")
    private String remark;
}
