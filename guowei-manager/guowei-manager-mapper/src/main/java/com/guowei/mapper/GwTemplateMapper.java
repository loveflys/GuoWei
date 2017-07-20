package com.guowei.mapper;

import com.guowei.pojo.GwTemplate;
import com.guowei.pojo.GwTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwTemplateMapper {
    int countByExample(GwTemplateExample example);

    int deleteByExample(GwTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwTemplate record);

    int insertSelective(GwTemplate record);

    List<GwTemplate> selectByExample(GwTemplateExample example);

    GwTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwTemplate record, @Param("example") GwTemplateExample example);

    int updateByExample(@Param("record") GwTemplate record, @Param("example") GwTemplateExample example);

    int updateByPrimaryKeySelective(GwTemplate record);

    int updateByPrimaryKey(GwTemplate record);
}