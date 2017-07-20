package com.guowei.mapper;

import com.guowei.pojo.GwDivision;
import com.guowei.pojo.GwDivisionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwDivisionMapper {
    int countByExample(GwDivisionExample example);

    int deleteByExample(GwDivisionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwDivision record);

    int insertSelective(GwDivision record);

    List<GwDivision> selectByExample(GwDivisionExample example);

    GwDivision selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwDivision record, @Param("example") GwDivisionExample example);

    int updateByExample(@Param("record") GwDivision record, @Param("example") GwDivisionExample example);

    int updateByPrimaryKeySelective(GwDivision record);

    int updateByPrimaryKey(GwDivision record);
}