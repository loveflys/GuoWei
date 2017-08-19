package com.guowei.mapper;

import com.guowei.pojo.GwApply;
import com.guowei.pojo.GwApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwApplyMapper {
    int countByExample(GwApplyExample example);

    int deleteByExample(GwApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwApply record);

    int insertSelective(GwApply record);

    List<GwApply> selectByExample(GwApplyExample example);

    GwApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwApply record, @Param("example") GwApplyExample example);

    int updateByExample(@Param("record") GwApply record, @Param("example") GwApplyExample example);

    int updateByPrimaryKeySelective(GwApply record);

    int updateByPrimaryKey(GwApply record);
}