package org.xinrui.kangyun.service;

import org.springframework.stereotype.Service;
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
