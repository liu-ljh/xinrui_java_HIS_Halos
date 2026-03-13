package org.xinrui.wuchuang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xinrui.common.entity.SampleInfo;

public interface LisSampleService extends IService<SampleInfo> {
    boolean removeWithCascade(Long oid);
}
