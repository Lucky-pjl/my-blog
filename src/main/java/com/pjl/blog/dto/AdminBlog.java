package com.pjl.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author pjl
 * @create 2020-02-02-11:29
 *
 * 此类是在博客管理页面显示的数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminBlog {

    private Integer id;
    private String title;
    private Date updateTime;
    private Integer recommend;

    private String typeName;

    @Override
    public String toString() {
        return "AdminBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                ", recommend=" + recommend +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
