package org.xinrui.kangyun.dto.testResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class SampleInfoDto {

    // 样本基础信息
    @ApiModelProperty("样本编号")
    private String sampleNo;

    @ApiModelProperty("原样本编号")
    private String oldSampleNum;

    @ApiModelProperty("产品套餐编号")
    private String productNo;

    @ApiModelProperty("产品套餐名称")
    private String productName;

    @ApiModelProperty(value = "样本类型（1：产前绒毛；2：流产物绒毛；4：胎儿组织；8：羊水；16：脐带血；32：产前样本DNA；128：产后样本DNA；64：外周血；256：羊水培养细胞）")
    private Integer sampleType;

    @ApiModelProperty("样本状态（8=报告生成）")
    private Integer sampleStatus;

    @ApiModelProperty("Q30质量值")
    private String q30;

    // 送检信息
    @ApiModelProperty("送检医院")
    private String hospitalName;

    @ApiModelProperty("送检科室")
    private String departmentName;

    @ApiModelProperty("科室ID")
    private Integer departmentId;

    @ApiModelProperty("送检医生")
    private String doctorName;

    @ApiModelProperty("门诊号/住院号")
    private String clinicNum;

    // 患者信息
    @ApiModelProperty("患者ID")
    private Integer patientId;

    @ApiModelProperty("患者姓名")
    private String patientName;

    @ApiModelProperty(value = "患者性别（1：男，2：女）")
    private Integer patientGender;

    @ApiModelProperty("患者年龄")
    private Integer patientAge;

    @ApiModelProperty("患者身份证")
    private String patientIdCard;

    @ApiModelProperty("患者联系电话")
    private String patientMobile;

    // 家系信息
    @ApiModelProperty(value = "是否录入家系（1：是，0：否）")
    private Integer isSavePedigree;

    @ApiModelProperty("先证者样本编号")
    private String probandSample;

    @ApiModelProperty(value = "已知家系关系（1：父亲；2：母亲；4：本人；8：其他）")
    private Integer clientRelation;

    // 时间信息
    @ApiModelProperty("采样日期")
    private Date collectDate;

    @ApiModelProperty("到样日期")
    private Date receivedDate;

    // 临床信息
    @ApiModelProperty(value = "受检者类型（1：确诊患者；2：疑似患者；4：表型正常人群；8：其他）")
    private Integer clientType;

    @ApiModelProperty(value = "送检原因（1：无创提示高风险；2：≥35岁孕妇；3：自然流产；4：稽留流产；5：胎儿畸形；6：死胎；7：其他）")
    private Integer detectReason;

    @ApiModelProperty("临床诊断")
    private String clinicalDiagnosis;

    @ApiModelProperty("送检原因/临床诊断")
    private String detectClinicalDiagnosis;

    // 生育史信息
    @ApiModelProperty("生育史（孕次）")
    private Integer gestationalTimes;

    @ApiModelProperty("生育史（产次）")
    private Integer childbirthTimes;

    @ApiModelProperty("生育史（自然流产次）")
    private Integer abortionTimes;

    @ApiModelProperty("取样孕周")
    private Integer gestationalWeeks;

    @ApiModelProperty(value = "是否借卵（1：是，0：否）")
    private Integer borrowOvumFlag;

    @ApiModelProperty("末次月经")
    private Date lastMenstrualPeriodDate;

    @ApiModelProperty(value = "是否单胎双胎检测（1：是，0：否）")
    private Integer fetusTestFlag;

    // 超声检查信息
    @ApiModelProperty(value = "是否做过超声检查（1：是，0：否）")
    private Integer ultrasonicFlag;

    @ApiModelProperty("超声检测日期")
    private Date ultrasoundTestDate;

    @ApiModelProperty(value = "超声检查是否异常（1：是，0：否）")
    private Integer ultrasonicAbnormalFlag;

    // 染色体检测信息
    @ApiModelProperty(value = "男方染色体检测（1：已做，2：未做）")
    private Integer maleDetectFlag;

    @ApiModelProperty("男方检测方法")
    private String detectMethodMale;

    @ApiModelProperty("男方结果")
    private String detectResultMale;

    @ApiModelProperty(value = "女方染色体检测（1：已做，2：未做）")
    private Integer femaleDetectFlag;

    @ApiModelProperty("女方检测方法")
    private String detectMethodFemale;

    @ApiModelProperty("女方结果")
    private String detectResultFemale;

    @ApiModelProperty(value = "子女染色体检测（1：已做，2：未做）")
    private Integer childDetectFlag;

    @ApiModelProperty("子女检测方法")
    private String detectMethodChild;

    @ApiModelProperty("子女结果")
    private String detectResultChild;

    // 疾病史信息
    @ApiModelProperty(value = "家族史（1：是，0：否）")
    private Integer illnessHistoryGeneticFlag;

    @ApiModelProperty("家族史详情")
    private String illnessHistoryGenetic;

    @ApiModelProperty("男方疾病既往史")
    private String illnessHistoryPastMale;

    @ApiModelProperty("女方疾病既往史")
    private String illnessHistoryPastFemale;

    // 其他
    @ApiModelProperty("备注")
    private String remark;
}