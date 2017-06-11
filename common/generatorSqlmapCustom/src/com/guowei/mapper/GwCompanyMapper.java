package com.guowei.mapper;

import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwCompanyMapper {
    int countByExample(GwCompanyExample example);

    int deleteByExample(GwCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwCompany record);

    int insertSelective(GwCompany record);

    List<GwCompany> selectByExample(GwCompanyExample example);

    GwCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwCompany record, @Param("example") GwCompanyExample example);

    int updateByExample(@Param("record") GwCompany record, @Param("example") GwCompanyExample example);

    int updateByPrimaryKeySelective(GwCompany record);

    int updateByPrimaryKey(GwCompany record);
}