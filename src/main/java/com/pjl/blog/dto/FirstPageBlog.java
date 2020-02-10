package com.pjl.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author pjl
 * @create 2020-02-03-11:32
 *
 * 此类用于传递在首页显示的博客数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPageBlog {

    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}
