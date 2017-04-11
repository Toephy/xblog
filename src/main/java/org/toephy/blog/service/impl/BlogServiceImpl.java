package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toephy.blog.dao.IBlogDao;
import org.toephy.blog.entity.Blog;
import org.toephy.blog.service.IBlogService;

import java.util.List;

/**
 * Created by Toephy on 2017/4/4 13:12
 */
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogDao blogDao;

    @Override
    public Blog getBlogById(int id) {
        return blogDao.getBlogbyId(id);
    }

    public List<Blog> blogList() {
        return blogDao.getAllBlogs();
    }

    public boolean addBlog(Blog blog) {
        return blogDao.insert(blog);
    }
}
