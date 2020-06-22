package com.pjl.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjl.blog.dto.AdminBlog;
import com.pjl.blog.dto.AdminSearchBlog;
import com.pjl.blog.pojo.Blog;
import com.pjl.blog.pojo.User;
import com.pjl.blog.service.BlogService;
import com.pjl.blog.service.TagService;
import com.pjl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-15:55
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    public void setType(Model model) {
        model.addAttribute("types", typeService.getAllType());

    }

    public void setTag(Model model){
        model.addAttribute("tags", tagService.getAllTag());
    }

    @GetMapping("/blogs")
    public String list(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);

        List<AdminBlog> allBlog = blogService.getAllAdminBlog();

        PageInfo<AdminBlog> pageInfo = new PageInfo<>(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        setType(model);
        return "admin/blogs";

    }


    @PostMapping("/blogs/search")
    public String search(AdminSearchBlog blog, Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {

        if(blog.getRecommend() == null){
            blog.setRecommend("0");
        }
        PageHelper.startPage(pageNum, 6);
        List<AdminBlog> allBlog = blogService.getBlogsBySearch(blog);
        PageInfo<AdminBlog> pageInfo = new PageInfo<>(allBlog);
        model.addAttribute("pageInfo", pageInfo);

        setType(model);

        return "admin/blogs";
    }

    //跳转到博客添加页面
    @GetMapping("/blogs/input")
    private String blogsadd(Model model){
        model.addAttribute("blog",new Blog());
        setType(model);
        setTag(model);
        return "admin/blogs-add";
    }

    @GetMapping("/blogs/{id}/input")
    private String update(@PathVariable Integer id,Model model){
        model.addAttribute("blog",new Blog());
        setType(model);
        setTag(model);
        Blog blog = blogService.getBlogById(id);
        blog.setIds(blogService.getTagsByBlogId(id));
        model.addAttribute("blog",blog);
        return "admin/blogs-add";
    }

    //新增和修改公用方法
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){

        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getId());
        blog.setTags(tagService.listTag(blog.getIds()));
        blog.setTypeId(blog.getType().getId());
        int i = blogService.saveBlog(blog);
        if(i == 0){
            attributes.addFlashAttribute("message","操作失败");
        }else{
            attributes.addFlashAttribute("message","操作成功");
        }


        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/index";
    }
}