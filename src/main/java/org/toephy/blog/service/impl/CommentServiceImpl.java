package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.toephy.blog.bean.dto.CommentDto;
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
    public List<CommentDto> getCommentList(int blogId) {
        List<CommentDto> commentList = commentDao.getCommentList(blogId);
        List<CommentDto> result = new ArrayList<CommentDto>();
        if (!CollectionUtils.isEmpty(commentList)) {
            for (CommentDto item : commentList) {
                if (item.getUser() != null) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

}
