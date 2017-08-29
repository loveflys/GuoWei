package com.guowei.mapper;

import com.guowei.pojo.GwUser;
import com.guowei.pojo.GwUserExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GwUserMapper {
    int countByExample(GwUserExample example);

    int deleteByExample(GwUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwUser record);

    int insertSelective(GwUser record);

    List<GwUser> selectByExample(GwUserExample example);

    GwUser selectByPrimaryKey(Long id);
    
    BigDecimal searchUserCount(Map<String,Object> params);

    int updateByExampleSelective(@Param("record") GwUser record, @Param("example") GwUserExample example);

    int updateByExample(@Param("record") GwUser record, @Param("example") GwUserExample example);

    int updateByPrimaryKeySelective(GwUser record);

    int updateByPrimaryKey(GwUser record);
}