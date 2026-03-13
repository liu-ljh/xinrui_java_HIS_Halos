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


//    /**
//     * 接收PDF报告文件
//     *
//     * @param file
//     * @return
//     */
//    boolean receivePdfReport(MultipartFile file);
//
//
//    /**
//     * 接收WORD报告文件
//     *
//     * @param file
//     * @return
//     */
//    boolean receiveWordReport(MultipartFile file);
}
