package com.pjl.blog.dao;

import com.pjl.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-03-16:58
 */
@Mapper
@Repository
public interface CommentDao {

    List<Comment> getCommentList(Integer id);

    int saveComment(Comment comment);

    Comment getParentComment(Integer ParentCommentId);
}
