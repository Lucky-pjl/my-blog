package com.pjl.blog.controller;

import com.pjl.blog.pojo.Comment;
import com.pjl.blog.service.CommentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-03-16:53
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${comment.avatar}")
    private String avatar;


    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Integer blogId, Model model){

        List<Comment> commentList = commentService.getCommentList(blogId);
        model.addAttribute("comments",commentList);

        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){

        comment.setAvatar(avatar);
        commentService.saveComment(comment);
        return "redirect:/comments/"+comment.getBlogId();
    }
}
