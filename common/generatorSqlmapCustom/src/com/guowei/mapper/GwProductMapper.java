package com.guowei.mapper;

import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwProductMapper {
    int countByExample(GwProductExample example);

    int deleteByExample(GwProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwProduct record);

    int insertSelective(GwProduct record);

    List<GwProduct> selectByExample(GwProductExample example);

    GwProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwProduct record, @Param("example") GwProductExample example);

    int updateByExample(@Param("record") GwProduct record, @Param("example") GwProductExample example);

    int updateByPrimaryKeySelective(GwProduct record);

    int updateByPrimaryKey(GwProduct record);
}