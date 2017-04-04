package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.toephy.blog.entity.Blog;

import java.util.List;

/**
 * Created by Toephy on 2017/4/4 12:49
 */
@Mapper
public interface IBlogDao {

    List<Blog> getAllBlogs();

    boolean insert(Blog blog);
}
