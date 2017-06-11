package com.guowei.mapper;

import com.guowei.pojo.GwCategory;
import com.guowei.pojo.GwCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwCategoryMapper {
    int countByExample(GwCategoryExample example);

    int deleteByExample(GwCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCategory record);

    int insertSelective(GwCategory record);

    List<GwCategory> selectByExample(GwCategoryExample example);

    GwCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCategory record, @Param("example") GwCategoryExample example);

    int updateByExample(@Param("record") GwCategory record, @Param("example") GwCategoryExample example);

    int updateByPrimaryKeySelective(GwCategory record);

    int updateByPrimaryKey(GwCategory record);
}