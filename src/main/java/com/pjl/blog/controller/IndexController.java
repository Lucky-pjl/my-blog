package com.pjl.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjl.blog.dto.DetailedBlog;
import com.pjl.blog.dto.FirstPageBlog;
import com.pjl.blog.dto.RecommendBlog;
import com.pjl.blog.exception.NotFoundException;
import com.pjl.blog.pojo.Comment;
import com.pjl.blog.pojo.Tag;
import com.pjl.blog.pojo.Type;
import com.pjl.blog.service.BlogService;
import com.pjl.blog.service.CommentService;
import com.pjl.blog.service.TagService;
import com.pjl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author pjl
 * @create 2020-01-31-15:11
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CommentService commentService;

    //来到主页
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 6);
        List<FirstPageBlog> allFirstPage = blogService.getFirstPageBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPage);

        //types
        List<Type> allType = typeService.getIndexTypes();
        //tags
        List<Tag> allTag = tagService.getIndexTags();
        //recommendBlog
        List<RecommendBlog> recommendBlog = blogService.getRecommendBlog();

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs",recommendBlog);
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }


    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> searchBlog = blogService.searchBlog(query);

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);

        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Integer id,Model model){

        List<Comment> commentList = commentService.getCommentList(id);
        model.addAttribute("comments",commentList);

        blogService.viewAdd(id);
        DetailedBlog blog = blogService.getDetailBlog(id);
        model.addAttribute("blog",blog);
        return "blog";
    }
}
