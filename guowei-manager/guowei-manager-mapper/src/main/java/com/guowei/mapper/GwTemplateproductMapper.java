package com.guowei.mapper;

import com.guowei.pojo.GwTemplateproduct;
import com.guowei.pojo.GwTemplateproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwTemplateproductMapper {
    int countByExample(GwTemplateproductExample example);

    int deleteByExample(GwTemplateproductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwTemplateproduct record);

    int insertSelective(GwTemplateproduct record);

    List<GwTemplateproduct> selectByExample(GwTemplateproductExample example);

    GwTemplateproduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwTemplateproduct record, @Param("example") GwTemplateproductExample example);

    int updateByExample(@Param("record") GwTemplateproduct record, @Param("example") GwTemplateproductExample example);

    int updateByPrimaryKeySelective(GwTemplateproduct record);

    int updateByPrimaryKey(GwTemplateproduct record);
}