package com.guowei.mapper;

import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderExample;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface GwOrderMapper {
    int countByExample(GwOrderExample example);

    int deleteByExample(GwOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwOrder record);

    int insertSelective(GwOrder record);

    List<GwOrder> selectByExample(GwOrderExample example);

    GwOrder selectByPrimaryKey(Long id);
    
    BigDecimal searchOrderAmount(Map<String,Object> params);

    int updateByExampleSelective(@Param("record") GwOrder record, @Param("example") GwOrderExample example);

    int updateByExample(@Param("record") GwOrder record, @Param("example") GwOrderExample example);

    int updateByPrimaryKeySelective(GwOrder record);

    int updateByPrimaryKey(GwOrder record);
}