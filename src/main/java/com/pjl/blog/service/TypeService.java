package com.pjl.blog.service;

import com.github.pagehelper.Page;
import com.pjl.blog.pojo.Type;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-16:31
 */
public interface TypeService {

    int saveType(Type type);

    Type getTypeById(Integer id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    int updateType(Type type);

    int deleteType(Integer id);

    List<Type> getIndexTypes();
}
