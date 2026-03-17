package org.xinrui.wuchuang.service;

import org.springframework.web.multipart.MultipartFile;

public interface TestReportFileService {
    /**
     * 获取报告文件
     *
     * @param file
     * @return
     */
    boolean receiveReport(MultipartFile file);


}
