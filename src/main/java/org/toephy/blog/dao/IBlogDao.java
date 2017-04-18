package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.toephy.blog.bean.entity.Blog;

import java.util.List;

/**
 * Created by Toephy on 2017/4/4 12:49
 */
@Mapper
public interface IBlogDao {

    int getCount();

    Blog getBlogbyId(int id);

    List<Blog> getAllBlogs();

    List<Blog> getBlogs(@Param("startIndex") int startIndex, @Param("offset") int offset);

    boolean insert(Blog blog);
}
