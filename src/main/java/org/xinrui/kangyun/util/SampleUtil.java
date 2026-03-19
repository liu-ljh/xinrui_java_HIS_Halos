package org.xinrui.kangyun.util;

/*
 * 包含entity->dto方法
 * 以及对于RequestSampleResponseDTO的一些校验（非空以及数值校验这些）
 * */

import org.xinrui.kangyun.dto.SampleDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class SampleUtil {

    private static final Long UPDATED_BY = 1L; // 固定更新人ID

    // 使用静态Validator实例
    private static final Validator VALIDATOR;

    static {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            VALIDATOR = factory.getValidator();
        }
    }

    /**
     * Entity 转 DTO
     */
//    public static SampleDto convertToDTO(SampleInfo sampleInfo) {
//        if (sampleInfo == null) {
//            return null;
//        }
//        return BeanConvertUtil.convert(sampleInfo, SampleDto.class);
//    }

    /**
     * 校验 DTO 对象
     *
     * @param dto 待校验对象
     * @throws javax.validation.ValidationException 如果校验失败，抛出异常包含详细错误信息
     */
    public static void RequestSampleValidate(SampleDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("待校验对象不能为 null");
        }

        // 执行校验
        Set<ConstraintViolation<SampleDto>> violations = VALIDATOR.validate(dto);

        if (!violations.isEmpty()) {
            // 收集所有错误信息拼接成字符串
            String errorMessage = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));

            throw new javax.validation.ValidationException("数据校验失败: " + errorMessage);
        }
    }


    /**
     * 转换样本 DTO 中的标志字段
     * 处理以下字段：
     * 1. borrowOvumFlag: 01-自体供卵，02-异体供卵 -> 2-否，1-是
     * 2. ultrasonicFlag: 是否做过超声检查，有数值为是，无数值为否
     * 3. ultrasonicAbnormalFlag: 超声检查是否异常，01-未见异常，02-提示异常 -> 1 是 0 否
     *
     * @param sampleDto 需要转换的 SampleDto 对象
     */
    public static void convertSampleFlags(SampleDto sampleDto) {
        //查出来的borrowOvumFlag需要重新转换，此时01-自体供卵，02-异体供卵，需要换成2-否，1-是
        if(sampleDto.getBorrowOvumFlag() == null){
            sampleDto.setBorrowOvumFlag(0);
        } else if(sampleDto.getBorrowOvumFlag() == 1) {
            sampleDto.setBorrowOvumFlag(2);
        } else if(sampleDto.getBorrowOvumFlag()==2){
            sampleDto.setBorrowOvumFlag(1);
        }else{
            sampleDto.setBorrowOvumFlag(0);
        }

        //查出来的ultrasonicFlag是否做过超声检查，此时01-未见异常，02-提示异常，需要换成1是0否，有数值为是，无数值为否
        if (sampleDto.getUltrasonicFlag()!= null && sampleDto.getUltrasonicFlag()!=0){
            sampleDto.setUltrasonicFlag(1);
        }else {
            sampleDto.setUltrasonicFlag(0);
        }

        //ultrasonicAbnormalFlag超声检查是否异常，此时01-未见异常，02-提示异常，需要换成1是0否
        if(sampleDto.getUltrasonicAbnormalFlag()==null){
            sampleDto.setUltrasonicAbnormalFlag(0);
        } else if(sampleDto.getUltrasonicAbnormalFlag()==1){
            sampleDto.setUltrasonicAbnormalFlag(0);
        } else if (sampleDto.getUltrasonicAbnormalFlag()==2) {
            sampleDto.setUltrasonicAbnormalFlag(1);
        }

        sampleDto.setOperator(UPDATED_BY);
        sampleDto.setOperationTime(LocalDateTime.now());
    }
}
