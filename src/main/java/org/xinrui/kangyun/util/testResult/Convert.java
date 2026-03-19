package org.xinrui.kangyun.util.testResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.xinrui.kangyun.dto.testResult.TestResultDto;

public class Convert {

    /**
     * 将TestResultDto转换为JSON字符串
     * @param dto DTO对象
     * @return JSON字符串
     */
    public static String convertToJSON(TestResultDto dto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("DTO转JSON失败", e);
        }
    }
}
