package org.xinrui.kangyun.mapper;

import org.apache.ibatis.annotations.Param;
import org.xinrui.wuchuang.dto.SampleDto;

public interface SampleMapper {

    SampleDto selectByOldSampleNum(@Param("oldSampleNum") String oldSampleNum);
}
