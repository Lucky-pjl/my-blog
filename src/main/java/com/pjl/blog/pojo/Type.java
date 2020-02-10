package com.pjl.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Integer id;
    @NotBlank(message = "分类不能为空")
    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public Type(String name) {
        this.name = name;
    }
}