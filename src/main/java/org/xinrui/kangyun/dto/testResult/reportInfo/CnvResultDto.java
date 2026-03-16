package org.xinrui.kangyun.dto.testResult.reportInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// ==================== CNV结果图DTO ====================
@Data
@ApiModel(description = "CNV测序结果图")
public class CnvResultDto {

    @ApiModelProperty("检测结果集合（拼接）")
    private String[] cnvResults;

    @ApiModelProperty("图片地址")
    private String imgUrl;
}
