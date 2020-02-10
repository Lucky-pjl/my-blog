package com.pjl.blog.service;

import com.pjl.blog.pojo.Comment;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-03-17:00
 */
public interface CommentService {

    List<Comment> getCommentList(Integer id);

    int saveComment(Comment comment);

}
