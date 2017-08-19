package com.guowei.mapper;

import com.guowei.pojo.GwComplain;
import com.guowei.pojo.GwComplainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwComplainMapper {
    int countByExample(GwComplainExample example);

    int deleteByExample(GwComplainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwComplain record);

    int insertSelective(GwComplain record);

    List<GwComplain> selectByExample(GwComplainExample example);

    GwComplain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwComplain record, @Param("example") GwComplainExample example);

    int updateByExample(@Param("record") GwComplain record, @Param("example") GwComplainExample example);

    int updateByPrimaryKeySelective(GwComplain record);

    int updateByPrimaryKey(GwComplain record);
}