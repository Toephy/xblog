package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toephy.blog.dao.ICommentDao;
import org.toephy.blog.bean.entity.Comment;
import org.toephy.blog.service.ICommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toephy on 2017.4.17 14:36
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentDao commentDao;

    @Override
    public List<Comment> getCommentList(int blogId) {
        List<Comment> commentList = commentDao.getCommentList(blogId);
        if (commentList != null) {
            return commentList;
        } else {
            return new ArrayList<Comment>();
        }
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

}
