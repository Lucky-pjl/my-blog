package com.pjl.blog.service;

import com.github.pagehelper.Page;
import com.pjl.blog.dao.TypeDao;
import com.pjl.blog.exception.NotFoundException;
import com.pjl.blog.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-16:35
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public int updateType(Type type) {

        Type t = typeDao.getTypeById(type.getId());
        if(t == null){
            throw new NotFoundException("此类型不存在!");
        }
        return typeDao.updateType(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeDao.deleteType(id);
    }

    @Override
    public List<Type> getIndexTypes() {
        return typeDao.getAllIndexType();
    }
}
