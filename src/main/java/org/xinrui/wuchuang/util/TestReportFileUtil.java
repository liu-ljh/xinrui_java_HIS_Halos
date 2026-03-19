package org.xinrui.wuchuang.util;

import lombok.extern.slf4j.Slf4j;
import org.xinrui.common.exception.BusinessException;
@Slf4j
public class TestReportFileUtil {

    /**
     * 从文件名中提取 sampleId
     *
     * @param fileName 文件名
     * @param extensionLen 文件扩展名长度
     * @return sampleId
     */
    public static String extractSampleIdFromFileName(String fileName, int extensionLen) {

        // 移除后缀
        String sampleId = fileName.substring(0, fileName.length() - extensionLen);

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
