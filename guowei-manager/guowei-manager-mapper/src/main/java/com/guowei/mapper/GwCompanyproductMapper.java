package com.guowei.mapper;

import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwCompanyproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwCompanyproductMapper {
    int countByExample(GwCompanyproductExample example);

    int deleteByExample(GwCompanyproductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCompanyproduct record);

    int insertSelective(GwCompanyproduct record);

    List<GwCompanyproduct> selectByExample(GwCompanyproductExample example);

    GwCompanyproduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCompanyproduct record, @Param("example") GwCompanyproductExample example);

    int updateByExample(@Param("record") GwCompanyproduct record, @Param("example") GwCompanyproductExample example);

    int updateByPrimaryKeySelective(GwCompanyproduct record);

    int updateByPrimaryKey(GwCompanyproduct record);
}