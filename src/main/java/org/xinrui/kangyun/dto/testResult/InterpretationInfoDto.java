package org.xinrui.kangyun.dto.testResult;

import java.util.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.xinrui.kangyun.dto.testResult.interpretationInfo.AnalysisSampleCnvListDto;
import org.xinrui.kangyun.dto.testResult.interpretationInfo.AnalysisSampleLohImprintListDto;
import org.xinrui.kangyun.dto.testResult.interpretationInfo.AnalysisSampleMccListDto;
import org.xinrui.kangyun.dto.testResult.interpretationInfo.AnalysisSampleVirusListDto;

@Data
public class InterpretationInfoDto {
    @ApiModelProperty(value = "操作建议（1：合格、2：重上机；4：重取样、8：警告）")
    private Integer suggent;

    @ApiModelProperty(value = "医生意见（1：合格、2：重上机；4：重取样、8：失败）")
    private Integer doctorOpinion;

    @ApiModelProperty(value = "验证状态（0：否、1：待验证、2：已验证、3：无）")
    private Integer validateStatus;

    @ApiModelProperty("CNV列表")
    private List<AnalysisSampleCnvListDto> analysisSampleCnvList;

    @ApiModelProperty("母源污染/三倍体提示列表")
    private List<AnalysisSampleMccListDto> analysisSampleMccList;

    @ApiModelProperty("LOH列表")
    private List<AnalysisSampleLohImprintListDto> analysisSampleLohImprintList;

    @ApiModelProperty("病原列表")
    private List<AnalysisSampleVirusListDto> analysisSampleVirusList;
}
