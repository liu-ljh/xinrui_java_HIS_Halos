package org.xinrui.kangyun.dto.testResult.interpretationInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnalysisSampleMccListDto {

    @ApiModelProperty("母源污染/三倍体高通量结果")
    private String mccTriploidSeqResult;

    @ApiModelProperty(value = "是否验证（0: 否,1: 待验证, 2: 已验证）")
    private Integer validated;

    @ApiModelProperty(value = "母源污染_验证结果（0: 未检测, 1: 无污染, 2: <30%, 3: >=30%, 4: 亲缘关系异常）")
    private Integer mccImprintResult;

    @ApiModelProperty(value = "三倍体_验证结果（0: Negative, 1: 69,XNN, 2: 69,XYY, 3: 69,XXY, 4: 69,XXX, 5: 单倍体或单亲二同体, 6: 其他）")
    private Integer triploidImprintResult;

    @ApiModelProperty("备注")
    private String remark;
}
