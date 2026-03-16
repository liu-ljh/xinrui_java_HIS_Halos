package org.xinrui.kangyun.dto.testResult.reportInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 参考文档中virusB19List、virusCMVList、virusTGList、virusTPList、virusVZVList 数据结构
 */
// ==================== 病原检测结果DTO ====================
@Data
@ApiModel(description = "病原检测结果")
public class VirusResultDto {

    @ApiModelProperty("病原中文名")
    private String pathogen;

    @ApiModelProperty("病原英文名")
    private String pathogenEn;

    @ApiModelProperty("检出序列数/总序列数")
    private String virusSeqResult;

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
