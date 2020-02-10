package com.pjl.blog.service;

import com.pjl.blog.dao.CommentDao;
import com.pjl.blog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-03-17:02
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommentList(Integer id) {
        return commentDao.getCommentList(id);
    }

    @Transactional
    @Override
    public int saveComment(Comment comment) {
        Integer parentCommentId = comment.getParentCommentId();

        comment.setCreateTime(new Date());
        return commentDao.saveComment(comment);
    }
}
