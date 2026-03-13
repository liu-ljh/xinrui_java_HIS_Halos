package org.xinrui.wuchuang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xinrui.common.entity.PatientInfo;


public interface MchiPatientService extends IService<PatientInfo> {
    boolean removeWithCascade(Long oid); // 新增级联删除方法
}
