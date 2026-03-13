package org.xinrui.wuchuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xinrui.common.entity.ExaminationInfo;
import org.xinrui.common.mapper.ExaminationInfoMapper;
import org.xinrui.wuchuang.service.LisExaminationService;

@Service
public class LisExaminationServiceImpl extends ServiceImpl<ExaminationInfoMapper, ExaminationInfo> implements LisExaminationService {
}
