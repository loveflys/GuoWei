package com.guowei.mapper;

import com.guowei.pojo.GwSupplierstorage;
import com.guowei.pojo.GwSupplierstorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwSupplierstorageMapper {
    int countByExample(GwSupplierstorageExample example);

    int deleteByExample(GwSupplierstorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwSupplierstorage record);

    int insertSelective(GwSupplierstorage record);

    List<GwSupplierstorage> selectByExample(GwSupplierstorageExample example);

    GwSupplierstorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwSupplierstorage record, @Param("example") GwSupplierstorageExample example);

    int updateByExample(@Param("record") GwSupplierstorage record, @Param("example") GwSupplierstorageExample example);

    int updateByPrimaryKeySelective(GwSupplierstorage record);

    int updateByPrimaryKey(GwSupplierstorage record);
}