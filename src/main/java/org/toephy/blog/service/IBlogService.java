package org.toephy.blog.service;

import org.toephy.blog.entity.Blog;

import java.util.List;

/**
 * Created by Toephy on 2017/4/4 13:12
 */
public interface IBlogService {

    Blog getBlogById(int id);

    List<Blog> blogList();

    boolean addBlog(Blog blog);
}
