package com.pjl.blog.service;

import com.pjl.blog.dao.BlogDao;
import com.pjl.blog.dto.*;
import com.pjl.blog.pojo.Blog;
import com.pjl.blog.pojo.Tag;
import com.pjl.blog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author pjl
 * @create 2020-02-02-10:48
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlogById(Integer id) {
        return blogDao.getBlogById(id);
    }

    @Override
    public List<AdminBlog> getAllAdminBlog() {

        return blogDao.getAllAdminBlog();
    }

    @Override
    public List<Blog> getAllBlog() {
        return null;
    }

    //添加与修改博客公用  如果传递的博客id为空则是添加
    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        int i;

        if(blog.getFlag().equals("") || blog.getFlag() == null){
            blog.setFlag("原创");
        }

        if(blog.getId() == null){
            //添加一篇新的博客
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
            List<Tag> tags = blog.getTags();

            i = blogDao.saveBlog(blog);
            List<BlogAndTag> bts = new ArrayList<>();
            for (Tag tag : tags){
                bts.add(new BlogAndTag(blog.getId(),tag.getId()));
            }
            blogDao.saveBlogAndTag(bts);
        } else {
            //修改一篇博客
            blog.setUpdateTime(new Date());
            i = blogDao.updateBlog(blog);

        }


        return i;
    }

    @Transactional
    @Override
    public int updateBlog(Blog blog) {

        return blogDao.updateBlog(blog);
    }

    @Transactional
    @Override
    public int deleteBlog(Integer id) {

        blogDao.deleteBlogAndTag(id);
        return blogDao.deleteBlog(id);
    }

    @Override
    public List<AdminBlog> getBlogsBySearch(AdminSearchBlog searchBlog) {
        return blogDao.getAdminBlogBySearch(searchBlog);
    }

    //根据博客的id获取它所具有的全部标签 并转换为字符串 1,2,3  的形式
    //用于在修改博客页面显示
    @Override
    public String getTagsByBlogId(Integer id) {

        List<Integer> tags = blogDao.getTagsByBlogId(id);
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(int i : tags){
                if(flag){
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(i);
            }
            return ids.toString();
        }
        return null;
    }

    //获取首页显示的博客信息
    @Override
    public List<FirstPageBlog> getFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    //首页推荐的博客信息
    @Override
    public List<RecommendBlog> getRecommendBlog() {
        return blogDao.getRecommendBlog();
    }

    //根据搜索栏条件查询博客
    @Override
    public List<FirstPageBlog> searchBlog(String query) {
        return blogDao.searchBlog(query);
    }

    //获取一篇博客的详细信息，传递到详情页面
    @Override
    public DetailedBlog getDetailBlog(Integer id) {
        DetailedBlog blog = blogDao.getDetailedBlogById(id);

        String content = blog.getContent();

        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        List<Tag> tags = blogDao.getTags(id);
        blog.setTags(tags);
        return blog;
    }

    //博客查看增加
    @Override
    public void viewAdd(Integer id) {
        blogDao.viewAdd(id);
    }

    //获取指定指定类型的博客列表
    @Override
    public List<FirstPageBlog> getBlogByTypeId(Integer id) {
        return blogDao.getBlogByTypeId(id);
    }

    //获取指定指定标签的博客列表
    @Override
    public List<FirstPageBlog> getBlogByTagId(Integer id) {

        List<FirstPageBlog> blogs = blogDao.getBlogByTagId(id);
        return blogs;
    }


    //获取归档的博客信息
    @Override
    public Map<String, List<Blog>> archiverBlog() {
        //获取所有年份
        List<String> years = blogDao.findGroupYear();

        Map<String,List<Blog>> map = new HashMap<>();
        for(String year : years){
            map.put(year,blogDao.getBlogByYear(year));
        }

        return map;
    }

    @Override
    public Integer countBlog() {
        return blogDao.countBlog();
    }
}
