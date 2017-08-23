package com.shik.dao.mapper;

import com.shik.dao.model.MyFile;
import com.shik.dao.model.MyFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyFileMapper {
    long countByExample(MyFileExample example);

    int deleteByExample(MyFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyFile record);

    int insertSelective(MyFile record);

    List<MyFile> selectByExample(MyFileExample example);

    MyFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MyFile record, @Param("example") MyFileExample example);

    int updateByExample(@Param("record") MyFile record, @Param("example") MyFileExample example);

    int updateByPrimaryKeySelective(MyFile record);

    int updateByPrimaryKey(MyFile record);
}