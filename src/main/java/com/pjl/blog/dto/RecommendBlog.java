package com.pjl.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pjl
 * @create 2020-02-03-12:40
 *
 * 博客首页推荐的博客信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendBlog {

    private Integer id;
    private String title;
    private Integer recommend;
}
