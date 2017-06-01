package com.guowei.mapper;

import com.guowei.pojo.GwManager;
import com.guowei.pojo.GwManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GwManagerMapper {
    int countByExample(GwManagerExample example);

    int deleteByExample(GwManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GwManager record);

    int insertSelective(GwManager record);

    List<GwManager> selectByExample(GwManagerExample example);

    GwManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GwManager record, @Param("example") GwManagerExample example);

    int updateByExample(@Param("record") GwManager record, @Param("example") GwManagerExample example);

    int updateByPrimaryKeySelective(GwManager record);

    int updateByPrimaryKey(GwManager record);
}