package com.pjl.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pjl
 * @create 2020-02-02-16:46
 *
 * 用于保存Blog和tag的一对多关系到数据表t_blog_tags中
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogAndTag {

    private Integer blog_id;
    private Integer tag_id;

}
