package com.shik.dao.mapper;

import com.shik.dao.model.Group;
import com.shik.dao.model.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(String groupid);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(String groupid);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}