package org.xinrui.kangyun.util;

import lombok.extern.slf4j.Slf4j;
import org.xinrui.common.exception.BusinessException;
@Slf4j
public class TestReportFileUtil {

    /**
     * 从文件名中提取 sampleId
     *
     * @param fileName 文件名
     * 例子：25S09660304-1_孙悦_运城市妇幼保健院_阳性_20260313.pdf
     * @return sampleId
     */
    public static String extractSampleIdFromFileName(String fileName) {
        // 以第一个下划线分割，取第一部分
        int firstUnderscoreIndex = fileName.indexOf('_');
        if (firstUnderscoreIndex == -1) {
            throw new BusinessException("文件名格式错误，未找到下划线分隔符");
        }

        String firstPart = fileName.substring(0, firstUnderscoreIndex);

        // 如果包含 "-"，则取 "-" 之前的部分作为 sampleId
        int dashIndex = firstPart.indexOf('-');
        String sampleId = dashIndex != -1 ? firstPart.substring(0, dashIndex) : firstPart;

        if (sampleId.isEmpty()) {
            throw new BusinessException("sampleId 不能为空");
        }

        log.info("从文件名 {} 中提取到 sampleId: {}", fileName, sampleId);
        return sampleId;
    }


    /**
     * 获取文件扩展名（小写）
     *
     * @param fileName 文件名
     * @return 文件扩展名（不含点号）
     */
    public static String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    }
}
