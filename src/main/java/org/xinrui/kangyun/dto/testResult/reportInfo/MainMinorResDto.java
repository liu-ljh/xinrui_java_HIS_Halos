package org.xinrui.kangyun.dto.testResult.reportInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// ==================== 主要/次要检测结果DTO ====================

/**
 * 参考文档中mainResList、minorResList的数据结构
 */
@Data
@ApiModel(description = "主要/次要检测结果")
public class MainMinorResDto {

    @ApiModelProperty("变异名称")
    private String variantInfo;

    @ApiModelProperty("变异类型")
    private String variantType;

    @ApiModelProperty("CNV长度")
    private String length;

    @ApiModelProperty("致病性分类")
    private String pathogenicity;

}
