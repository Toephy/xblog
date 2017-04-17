package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.toephy.blog.entity.Comment;

import java.util.List;

/**
 * Created by Toephy on 2017.4.17 14:27
 */
@Mapper
public interface ICommentDao {

    /**
     * 获取博客评论列表
     * @param blogId
     * @return
     */
    List<Comment> getCommentList(int blogId);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    boolean insertComment(Comment comment);


}
