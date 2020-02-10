package com.pjl.blog.service;

import com.pjl.blog.dto.*;
import com.pjl.blog.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author pjl
 * @create 2020-02-02-10:42
 */
public interface BlogService {

    Blog getBlogById(Integer id);

    List<AdminBlog> getAllAdminBlog();

    List<Blog> getAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Integer id);

    List<AdminBlog> getBlogsBySearch(AdminSearchBlog adminSearchBlog);

    String getTagsByBlogId(Integer id);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getRecommendBlog();

    List<FirstPageBlog> searchBlog(String query);

    DetailedBlog getDetailBlog(Integer id);

    void viewAdd(Integer id);

    List<FirstPageBlog> getBlogByTypeId(Integer id);

    List<FirstPageBlog> getBlogByTagId(Integer id);


    Map<String,List<Blog>> archiverBlog();

    Integer countBlog();
}
