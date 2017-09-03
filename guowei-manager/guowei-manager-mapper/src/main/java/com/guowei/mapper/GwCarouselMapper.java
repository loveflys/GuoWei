package com.guowei.mapper;

import com.guowei.pojo.GwCarousel;
import com.guowei.pojo.GwCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwCarouselMapper {
    int countByExample(GwCarouselExample example);

    int deleteByExample(GwCarouselExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCarousel record);

    int insertSelective(GwCarousel record);

    List<GwCarousel> selectByExample(GwCarouselExample example);

    GwCarousel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCarousel record, @Param("example") GwCarouselExample example);

    int updateByExample(@Param("record") GwCarousel record, @Param("example") GwCarouselExample example);

    int updateByPrimaryKeySelective(GwCarousel record);

    int updateByPrimaryKey(GwCarousel record);
}