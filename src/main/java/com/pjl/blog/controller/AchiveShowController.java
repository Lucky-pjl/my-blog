package com.pjl.blog.controller;

import com.pjl.blog.pojo.Blog;
import com.pjl.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pjl
 * @create 2020-02-04-12:02
 */
@Controller
public class AchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archiveMap",blogService.archiverBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }

}
