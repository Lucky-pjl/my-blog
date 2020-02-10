package com.pjl.blog.dao;

import com.pjl.blog.dto.*;
import com.pjl.blog.pojo.Blog;
import com.pjl.blog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-02-10:48
 */
@Mapper
@Repository
public interface BlogDao {

    Blog getBlogById(Integer id);

    List<AdminBlog> getAllAdminBlog();

    List<Blog> getAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Integer id);

    List<AdminBlog> getAdminBlogBySearch(AdminSearchBlog adminSearchBlog);

    void saveBlogAndTag(@Param("bts") List<BlogAndTag> bts);

    void deleteBlogAndTag(Integer id);

    //----------------------------------------------------------------

    List<Integer> getTagsByBlogId(Integer id);

    List<Tag> getTags(Integer id);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getRecommendBlog();

    List<FirstPageBlog> searchBlog(String query);

    DetailedBlog getDetailedBlogById(Integer id);

    void viewAdd(Integer id);

    List<FirstPageBlog> getBlogByTypeId(Integer id);

    List<FirstPageBlog> getBlogByTagId(Integer id);


    //下面两个方法用于归档
    List<String> findGroupYear();

    List<Blog> getBlogByYear(String year);

    Integer countBlog();

}
