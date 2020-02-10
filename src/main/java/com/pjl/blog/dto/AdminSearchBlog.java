package com.pjl.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pjl
 * @create 2020-02-02-13:55
 *
 * 此类用于封装后台博客管理页面使用搜索功能时传递到后台的数据
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSearchBlog {

    private String title;
    private Integer typeId;
    private String recommend;
}
