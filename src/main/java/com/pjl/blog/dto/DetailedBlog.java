package com.pjl.blog.dto;

import com.pjl.blog.pojo.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-03-14:31
 *
 * 博客详情页面用到的数据
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBlog {

    private Integer id;
    private String title;
    private String content;

    private String firstPicture;
    private String flag;
    private Integer views;
    private Date updateTime;

    private String typeName;

    private String nickname;
    private String avatar;

    private List<Tag> tags = new ArrayList<>();
}
