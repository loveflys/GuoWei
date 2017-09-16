package com.guowei.mapper;

import com.guowei.pojo.GwOrderdetail;
import com.guowei.pojo.GwOrderdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwOrderdetailMapper {
    int countByExample(GwOrderdetailExample example);

    int deleteByExample(GwOrderdetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwOrderdetail record);

    int insertSelective(GwOrderdetail record);

    List<GwOrderdetail> selectByExample(GwOrderdetailExample example);

    GwOrderdetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwOrderdetail record, @Param("example") GwOrderdetailExample example);

    int updateByExample(@Param("record") GwOrderdetail record, @Param("example") GwOrderdetailExample example);

    int updateByPrimaryKeySelective(GwOrderdetail record);

    int updateByPrimaryKey(GwOrderdetail record);
}