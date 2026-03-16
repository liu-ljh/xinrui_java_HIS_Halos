package org.xinrui.kangyun.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xinrui.kangyun.dto.SampleDto;

@Mapper
@Repository("KangyunSampleMapper")
public interface SampleMapper {

    SampleDto selectByOldSampleNum(@Param("oldSampleNum") String oldSampleNum);
}
