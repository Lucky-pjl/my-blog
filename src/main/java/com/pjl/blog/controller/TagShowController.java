package com.pjl.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjl.blog.dto.FirstPageBlog;
import com.pjl.blog.pojo.Tag;
import com.pjl.blog.service.BlogService;
import com.pjl.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-04-11:09
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                       @PathVariable Integer id){

        List<Tag> tags = tagService.getIndexTags();

        //表示是从导航栏点进来的
        if (id == -1) {
            id = tags.get(0).getId();
        }

        List<FirstPageBlog> blogs = blogService.getBlogByTagId(id);
        PageHelper.startPage(pageNum, 100);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);

        model.addAttribute("tags",tags);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTagId",id);


        return "tags";
    }
}
