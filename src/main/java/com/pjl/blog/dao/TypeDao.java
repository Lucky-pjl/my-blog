package com.pjl.blog.dao;

import com.pjl.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-16:36
 */
@Mapper
@Repository
public interface TypeDao {

    int saveType(Type type);

    Type getTypeById(Integer id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    int deleteType(Integer id);

    int updateType(Type type);

    List<Type> getAllIndexType();
}
