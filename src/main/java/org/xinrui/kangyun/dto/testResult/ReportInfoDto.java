package org.xinrui.kangyun.dto.testResult;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.xinrui.kangyun.dto.testResult.reportInfo.*;

import java.util.List;
import java.util.Map;

/**
 * 报告信息DTO（基于7.1.5 报告字段V413规范）
 * 通过 prenatalDetectionFlag/postpartumDetectionFlag 判断100K报告，否则为1M报告
 */
@Data
@ApiModel(description = "报告中心信息（V413）")
public class ReportInfoDto {

    // ==================== 一、样本信息及基础信息（共用）====================
    @ApiModelProperty("孕妇姓名/受检者姓名")
    @JsonProperty("${patientName}")
    private String patientName;

    @ApiModelProperty("报告类型 1:阴性,2:正式")
    @JsonProperty("${detectionResult}")
    private Integer detectionResult;

    @ApiModelProperty("样本编号")
    @JsonProperty("${sampleNo}")
    private String sampleNo;

    @ApiModelProperty("住院号/门诊号")
    @JsonProperty("${clinicNum}")
    private String clinicNum;

    @ApiModelProperty("性别字符串")
    @JsonProperty("${genderField}")
    private String genderField;

    @ApiModelProperty("性别")
    @JsonProperty("${genderValue}")
    private String genderValue;

    @ApiModelProperty("孕周字符串")
    @JsonProperty("${weekField}")
    private String weekField;

    @ApiModelProperty("孕周")
    @JsonProperty("${weekValue}")
    private String weekValue;

    @ApiModelProperty("天数")
    @JsonProperty("${dayValue}")
    private String dayValue;

    @ApiModelProperty("W标识")
    @JsonProperty("${wValue}")
    private String wValue;

    @ApiModelProperty("样本类型")
    @JsonProperty("${sampleType}")
    private String sampleType;

    @ApiModelProperty("电话")
    @JsonProperty("${patientMobile}")
    private String patientMobile;

    @ApiModelProperty("年龄")
    @JsonProperty("${patientAge}")
    private String patientAge;

    @ApiModelProperty("送检医生")
    @JsonProperty("${doctorName}")
    private String doctorName;

    @ApiModelProperty("送检医院")
    @JsonProperty("${hospitalName}")
    private String hospitalName;

    @ApiModelProperty("科室")
    @JsonProperty("${departmentName}")
    private String departmentName;

    @ApiModelProperty("采样时间")
    @JsonProperty("${collectDate}")
    private String collectDate;

    @ApiModelProperty("到样日期")
    @JsonProperty("${receivedDate}")
    private String receivedDate;

    @ApiModelProperty("原样本编号")
    @JsonProperty("${oldSampleNum}")
    private String oldSampleNum;

    @ApiModelProperty("检测原因/临床诊断")
    @JsonProperty("${detectClinicalDiagnosis}")
    private String detectClinicalDiagnosis;

    // ==================== 二、100K报告独有字段====================

    @ApiModelProperty("100K配置：产前（即送检单选择了胚胎/胎儿送检单）")
    @JsonProperty("${prenatalDetectionFlag}")
    private Boolean prenatalDetectionFlag;

    @ApiModelProperty("100K配置：产后（即送检单选择了疑似患者送检单）")
    @JsonProperty("${postpartumDetectionFlag}")
    private Boolean postpartumDetectionFlag;

    // ==================== 三、1M/100K报告共用字段====================

    @ApiModelProperty("测序仪名称")
    @JsonProperty("${platform}")
    private String platform;

    @ApiModelProperty("是否展示upd报告")
    @JsonProperty("${updResultFlag}")
    private Boolean updResultFlag;

    @ApiModelProperty("Upd检测结果数组列表")
    @JsonProperty("${updResultList}")
    private List<UpdResultDto> updResultList;

    @ApiModelProperty("报告创建时间")
    @JsonProperty("${reportCreateTime}")
    private String reportCreateTime;

    @ApiModelProperty("是否展示B19病原检测报告")
    @JsonProperty("${virusB19Flag}")
    private Boolean virusB19Flag;

    @ApiModelProperty("B19病原检测结果")
    @JsonProperty("${virusB19List}")
    private List<VirusResultDto> virusB19List;

    @ApiModelProperty("是否展示CMV病原检测报告")
    @JsonProperty("${virusCMVFlag}")
    private Boolean virusCMVFlag;

    @ApiModelProperty("CMV病原检测结果")
    @JsonProperty("${virusCMVList}")
    private List<VirusResultDto> virusCMVList;

    @ApiModelProperty("CMV病原载量")
    @JsonProperty("${CMVviralLoad}")
    private String cmvViralLoad;

    @ApiModelProperty("是否展示弓形虫病原检测报告")
    @JsonProperty("${virusTGFlag}")
    private Boolean virusTGFlag;

    @ApiModelProperty("弓形虫病原检测结果")
    @JsonProperty("${virusTGList}")
    private List<VirusResultDto> virusTGList;

    @ApiModelProperty("是否展示宫内梅毒螺旋体感染病原检测报告")
    @JsonProperty("${virusTPFlag}")
    private Boolean virusTPFlag;

    @ApiModelProperty("宫内梅毒螺旋体感染病原检测结果")
    @JsonProperty("${virusTPList}")
    private List<VirusResultDto> virusTPList;

    @ApiModelProperty("是否展示VZV病原检测结果")
    @JsonProperty("${virusVZVFlag}")
    private Boolean virusVZVFlag;

    @ApiModelProperty("VZV病原检测结果")
    @JsonProperty("${virusVZVList}")
    private List<VirusResultDto> virusVZVList;

    @ApiModelProperty("三倍体检测结果（100K：阴性报告不存在此字段，正式报告存在；1M：始终存在）")
    @JsonProperty("${triploidImprintResult}")
    private String triploidImprintResult;

    @ApiModelProperty("是否展示主要检测结果变异名称表头")
    @JsonProperty("${mainResHead}")
    private String mainResHead;

    @ApiModelProperty("主要检测结果列表")
    @JsonProperty("${mainResList}")
    private List<MainMinorResDto> mainResList;

    @ApiModelProperty("是否展示次要检测结果的默认值")
    @JsonProperty("${mainResFoot}")
    private String mainResFoot;

    @ApiModelProperty("是否展示次要检测结果变异名称表头")
    @JsonProperty("${minorResHead}")
    private String minorResHead;

    @ApiModelProperty("次要检测结果列表")
    @JsonProperty("${minorResList}")
    private List<MainMinorResDto> minorResList;

    @ApiModelProperty("是否展示次要检测结果的默认值")
    @JsonProperty("${minorResFoot}")
    private String minorResFoot;

    @ApiModelProperty("检测结果说明")
    @JsonProperty("${resultInterpretations}")
    private String resultInterpretations;

    @ApiModelProperty("检测结果声明补充Y染色体")
    @JsonProperty("${statementSuffix}")
    private String statementSuffix;

    //todo 接口文档对此处类型定义前后矛盾，待确认
    @ApiModelProperty("测序结果图集合（动态键名：Chr1, Chr2...）")
    @JsonProperty("${cnvResultList}")
    private Map<String, List<CnvResultDto>> cnvResultList;

    @ApiModelProperty("电子核型图")
    @JsonProperty("${electronicKaryotype}")
    private String electronicKaryotype;

    // ==================== 四、报告类型判断方法====================

    /**
     * 判断是否为100K报告
     * 根据文档7.1.5：100K报告有prenatalDetectionFlag和postpartumDetectionFlag字段
     */
    @JsonIgnore
    public boolean is100kReport() {
        return this.prenatalDetectionFlag != null || this.postpartumDetectionFlag != null;
    }

    /**
     * 获取报告类型字符串
     * @return "100k" 或 "1M"
     */
    @JsonIgnore
    public String getReportType() {
        return is100kReport() ? "100k" : "1M";
    }
}
