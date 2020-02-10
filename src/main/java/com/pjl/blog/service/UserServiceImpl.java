package com.pjl.blog.service;

import com.pjl.blog.dao.UserDao;
import com.pjl.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pjl
 * @create 2020-02-01-14:31
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username,password);
        return user;
    }
}
