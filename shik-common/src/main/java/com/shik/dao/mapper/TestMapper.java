package com.shik.dao.mapper;

import com.shik.dao.model.Test;
import com.shik.dao.model.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}