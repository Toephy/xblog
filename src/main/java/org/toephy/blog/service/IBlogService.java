package org.toephy.blog.service;

import org.toephy.blog.bean.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by Toephy on 2017/4/4 13:12
 */
public interface IBlogService {

    Blog getBlogById(int id);

    Map<String, Object> blogList(int pageNo, int pageSize);

    boolean addBlog(Blog blog);
}
