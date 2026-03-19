package org.xinrui.kangyun.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xinrui.common.exception.BusinessException;
import org.xinrui.kangyun.*;
import org.xinrui.kangyun.dto.SampleDto;
import org.xinrui.kangyun.mapper.SampleMapper;
import org.xinrui.kangyun.service.SampleService;
import org.xinrui.kangyun.util.SampleUtil;

import java.time.LocalDateTime;

@Slf4j
@Service("KangyunSampleService")
public class SampleServiceImpl implements SampleService {


    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public SampleDto getSample(String oldSampleNum) {
        // 1. 查询数据库（优先使用唯一索引字段）
        SampleDto sampleDto = sampleMapper.selectByOldSampleNum(oldSampleNum);
        if (sampleDto == null) {
            log.warn("样本信息不存在，原样本编号: {}", oldSampleNum);
            throw new BusinessException("-1", "请求的资源不存在");
        }

        //2.属性的校验，确保部分字段的必填以及数值的规定
        SampleUtil.RequestSampleValidate(sampleDto);

        //3.对一些字段进行转换
        SampleUtil.convertSampleFlags(sampleDto);

        log.info("样本信息查询成功，样本编号: {}", sampleDto.getSampleNo());
        return sampleDto;
    }
}
