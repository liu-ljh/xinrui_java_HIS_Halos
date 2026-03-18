package org.xinrui.kangyun.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
public class SampleDto {

    @ApiModelProperty(value = "样本编号", required = true)
    @NotBlank(message = "样本编号不能为空")
    private String sampleNo;

    @ApiModelProperty(value = "原样本编号")
    private String oldSampleNum;

    @ApiModelProperty(value = "产品套餐编号", required = true)
    @NotBlank(message = "产品套餐编号不能为空")
    private String productNo;


    @ApiModelProperty(value = "样本类型（1：产前绒毛；2：流产物绒毛；4：胎儿组织；8：羊水；16：脐带血；32：产前样本DNA；128：产后样本DNA；64：外周血；256：羊水培养细胞）", required = true)
    @NotNull(message = "样本类型不能为空")
    private Integer sampleType;

    @ApiModelProperty(value = "送检医院", required = true)
    @NotBlank(message = "送检医院不能为空")
    private String hospitalName;

    @ApiModelProperty(value = "送检科室", required = true)
    @NotBlank(message = "送检科室不能为空")
    private String departmentName;

    @ApiModelProperty(value = "送检医生", required = true)
    @NotBlank(message = "送检医生不能为空")
    private String doctorName;

    @ApiModelProperty(value = "门诊号/住院号", required = true)
    @NotBlank(message = "门诊号/住院号不能为空")
    private String clinicNum;

    @ApiModelProperty(value = "是否录入家系（1：是，0：否）", required = true)
    @NotNull(message = "是否录入家系不能为空")
    private Integer isSavePedigree;

    @ApiModelProperty(value = "先证者样本编号")
    private String probandSample;

    @ApiModelProperty(value = "已知家系关系（1：父亲；2：母亲；4：本人；8：其他）", required = true)
    @NotNull(message = "已知家系关系不能为空")
    private Integer clientRelation;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不能为空")
    private String patientName;

    @ApiModelProperty(value = "性别（1：男、2：女）", required = true)
    @NotNull(message = "性别不能为空")
    private Integer patientGender;

    @ApiModelProperty(value = "年龄（格式：xx岁xx月xx日，示例：30,0,0）", required = true)
    @NotBlank(message = "年龄不能为空")
    private String patientAge;

    @ApiModelProperty(value = "身份证", required = true)
    @NotBlank(message = "身份证不能为空")
    private String patientIdCard;

    @ApiModelProperty(value = "采样日期（格式：yyyy-MM-dd）", required = true)
    @NotBlank(message = "采样日期不能为空")
    private String collectDate;

    @ApiModelProperty(value = "到样日期（格式：yyyy-MM-dd）", required = true)
    @NotBlank(message = "到样日期不能为空")
    private String receivedDate;

    @ApiModelProperty(value = "联系电话", required = true)
    @NotBlank(message = "联系电话不能为空")
    private String patientMobile;

    @ApiModelProperty(value = "受检者类型（1：确诊患者；2：疑似患者；4：表型正常人群；8：其他）", required = true)
    @NotNull(message = "受检者类型不能为空")
    private Integer clientType;

    @ApiModelProperty(value = "送检原因（1：无创提示高风险；2：≥35岁孕妇；3：自然流产；4：稽留流产；5：胎儿畸形；6：死胎；7：其他，可多选，逗号分隔）", required = true)
    @NotBlank(message = "送检原因不能为空")
    private String detectReason;

    @ApiModelProperty(value = "临床诊断", required = true)
    @NotBlank(message = "临床诊断不能为空")
    private String clinicalDiagnosis;

    @ApiModelProperty(value = "送检原因/临床诊断")
    private String detectClinicalDiagnosis;

    @ApiModelProperty(value = "生育史（孕次）", required = true)
    @NotNull(message = "孕次不能为空")
    private Integer gestationalTimes;

    @ApiModelProperty(value = "生育史（产次）", required = true)
    @NotNull(message = "产次不能为空")
    private Integer childbirthTimes;

    @ApiModelProperty(value = "生育史（自然流产次）", required = true)
    @NotNull(message = "自然流产次不能为空")
    private Integer abortionTimes;

    @ApiModelProperty(value = "取样孕周（格式：周数,天数，示例：7,5）")
    private String gestationalWeeks;

    @ApiModelProperty(value = "是否借卵（1：是，0：否）", required = true)
    @NotNull(message = "是否借卵不能为空")
    private Integer borrowOvumFlag;

    @ApiModelProperty(value = "末次月经（格式：yyyy-MM-dd）", required = true)
    @NotBlank(message = "末次月经不能为空")
    private String lastMenstrualPeriodDate;

    @ApiModelProperty(value = "是否单胎双胎检测（1：是，0：否）", required = true)
    @NotNull(message = "是否单胎双胎检测不能为空")
    private Integer fetusTestFlag;

    @ApiModelProperty(value = "是否做过超声检查（1：是，0：否）", required = true)
    @NotNull(message = "是否做过超声检查不能为空")
    private Integer ultrasonicFlag;

    @ApiModelProperty(value = "超声检测日期（格式：yyyy-MM-dd）")
    private String ultrasoundTestDate;

    @ApiModelProperty(value = "超声检查是否异常（1：是，0：否）", required = true)
    @NotNull(message = "超声检查是否异常不能为空")
    private Integer ultrasonicAbnormalFlag;

    @ApiModelProperty(value = "男方染色体检测（1：已做，2：未做）", required = true)
    @NotNull(message = "男方染色体检测不能为空")
    private Integer maleDetectFlag;

    @ApiModelProperty(value = "男方检测方法")
    private String detectMethodMale;

    @ApiModelProperty(value = "男方结果")
    private String detectResultMale;

    @ApiModelProperty(value = "女方染色体检测（1：已做，2：未做）", required = true)
    @NotNull(message = "女方染色体检测不能为空")
    private Integer femaleDetectFlag;

    @ApiModelProperty(value = "女方检测方法")
    private String detectMethodFemale;

    @ApiModelProperty(value = "女方结果")
    private String detectResultFemale;

    @ApiModelProperty(value = "子女染色体检测（1：已做，2：未做）", required = true)
    @NotNull(message = "子女染色体检测不能为空")
    private Integer childDetectFlag;

    @ApiModelProperty(value = "子女检测方法")
    private String detectMethodChild;

    @ApiModelProperty(value = "子女结果")
    private String detectResultChild;

    @ApiModelProperty(value = "家族史（1：是，0：否）", required = true)
    @NotNull(message = "家族史不能为空")
    private Integer illnessHistoryGeneticFlag;

    @ApiModelProperty(value = "家族史详情")
    private String illnessHistoryGenetic;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "男方疾病既往史")
    private String illnessHistoryPastMale;

    @ApiModelProperty(value = "女方疾病既往史")
    private String illnessHistoryPastFemale;

    @ApiModelProperty(value = "操作人")
    private Long operator;

    @ApiModelProperty(value = "操作时间（格式：yyyy-MM-dd）")
    private LocalDateTime operationTime;

    // 以下字段根据响应示例补充（文档未明确但示例存在）
    @ApiModelProperty(value = "检测对象（文档未明确，示例中存在）")
    private Integer detectObj;

}
