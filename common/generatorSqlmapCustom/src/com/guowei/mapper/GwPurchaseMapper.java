package com.guowei.mapper;

import com.guowei.pojo.GwPurchase;
import com.guowei.pojo.GwPurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwPurchaseMapper {
    int countByExample(GwPurchaseExample example);

    int deleteByExample(GwPurchaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwPurchase record);

    int insertSelective(GwPurchase record);

    List<GwPurchase> selectByExample(GwPurchaseExample example);

    GwPurchase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwPurchase record, @Param("example") GwPurchaseExample example);

    int updateByExample(@Param("record") GwPurchase record, @Param("example") GwPurchaseExample example);

    int updateByPrimaryKeySelective(GwPurchase record);

    int updateByPrimaryKey(GwPurchase record);
}