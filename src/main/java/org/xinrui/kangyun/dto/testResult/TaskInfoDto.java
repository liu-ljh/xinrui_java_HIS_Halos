package org.xinrui.kangyun.dto.testResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TaskInfoDto {
    @ApiModelProperty("芯片号")
    private String slideNo;

    @ApiModelProperty("Lane ID")
    private String laneNo;

    @ApiModelProperty("DNB ID")
    private String dnbId;
}
