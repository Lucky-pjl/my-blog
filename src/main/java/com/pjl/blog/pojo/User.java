package com.pjl.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;

    private Integer power;//权限Id
    private Date createTime;
    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();

}
