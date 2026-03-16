package org.xinrui.kangyun.dto.testResult.reportInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// ==================== UPD结果DTO ====================
@Data
@ApiModel(description = "UPD检测结果")
public class UpdResultDto {

    @ApiModelProperty("疾病名称")
    private String upd;

    @ApiModelProperty("致病位置")
    private String updDiseaseRegion;

    @ApiModelProperty("致病区段")
    private String location;

    @ApiModelProperty("致病性分类")
    private String pathogenicity;

    @ApiModelProperty("染色体")
    private String chrom;

    @ApiModelProperty("临床表现")
    private String updClinical;

    @ApiModelProperty("文献")
    private String pmidReference;
}






