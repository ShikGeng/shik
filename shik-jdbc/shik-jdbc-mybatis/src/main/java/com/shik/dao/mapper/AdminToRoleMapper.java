package com.shik.dao.mapper;

import com.shik.dao.model.AdminToRole;
import com.shik.dao.model.AdminToRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminToRoleMapper {
    long countByExample(AdminToRoleExample example);

    int deleteByExample(AdminToRoleExample example);

    int insert(AdminToRole record);

    int insertSelective(AdminToRole record);

    List<AdminToRole> selectByExample(AdminToRoleExample example);

    int updateByExampleSelective(@Param("record") AdminToRole record, @Param("example") AdminToRoleExample example);

    int updateByExample(@Param("record") AdminToRole record, @Param("example") AdminToRoleExample example);
}