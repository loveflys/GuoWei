package com.guowei.mapper;

import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwOrderMapper {
    int countByExample(GwOrderExample example);

    int deleteByExample(GwOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwOrder record);

    int insertSelective(GwOrder record);

    List<GwOrder> selectByExample(GwOrderExample example);

    GwOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwOrder record, @Param("example") GwOrderExample example);

    int updateByExample(@Param("record") GwOrder record, @Param("example") GwOrderExample example);

    int updateByPrimaryKeySelective(GwOrder record);

    int updateByPrimaryKey(GwOrder record);
}