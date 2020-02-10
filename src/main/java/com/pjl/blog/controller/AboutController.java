package com.pjl.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pjl
 * @create 2020-02-04-13:46
 */
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
