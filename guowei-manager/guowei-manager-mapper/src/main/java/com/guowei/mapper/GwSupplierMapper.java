package com.guowei.mapper;

import com.guowei.pojo.GwSupplier;
import com.guowei.pojo.GwSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwSupplierMapper {
    int countByExample(GwSupplierExample example);

    int deleteByExample(GwSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwSupplier record);

    int insertSelective(GwSupplier record);

    List<GwSupplier> selectByExample(GwSupplierExample example);

    GwSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwSupplier record, @Param("example") GwSupplierExample example);

    int updateByExample(@Param("record") GwSupplier record, @Param("example") GwSupplierExample example);

    int updateByPrimaryKeySelective(GwSupplier record);

    int updateByPrimaryKey(GwSupplier record);
}