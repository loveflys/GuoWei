package com.guowei.mapper;

import com.guowei.pojo.GwCompanyprochange;
import com.guowei.pojo.GwCompanyprochangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwCompanyprochangeMapper {
    int countByExample(GwCompanyprochangeExample example);

    int deleteByExample(GwCompanyprochangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCompanyprochange record);

    int insertSelective(GwCompanyprochange record);

    List<GwCompanyprochange> selectByExample(GwCompanyprochangeExample example);

    GwCompanyprochange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCompanyprochange record, @Param("example") GwCompanyprochangeExample example);

    int updateByExample(@Param("record") GwCompanyprochange record, @Param("example") GwCompanyprochangeExample example);

    int updateByPrimaryKeySelective(GwCompanyprochange record);

    int updateByPrimaryKey(GwCompanyprochange record);
}