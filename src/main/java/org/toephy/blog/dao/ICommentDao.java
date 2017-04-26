package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.toephy.blog.bean.dto.CommentDto;
import org.toephy.blog.bean.entity.Comment;

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
    List<CommentDto> getCommentList(int blogId);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    boolean insertComment(Comment comment);


}
