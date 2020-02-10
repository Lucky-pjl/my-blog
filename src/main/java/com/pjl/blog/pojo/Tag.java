package com.pjl.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Integer id;
    private String name;

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<Blog> blogs = new ArrayList<>();
}