package com.pjl.blog.dao;

import com.pjl.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author pjl
 * @create 2020-02-01-14:34
 */
@Mapper
@Repository
public interface UserDao {

    User queryByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}
