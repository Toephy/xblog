package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toephy.blog.dao.IBlogDao;
import org.toephy.blog.bean.entity.Blog;
import org.toephy.blog.service.IBlogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> blogList(int pageNo, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        int totalRecord = blogDao.getCount();
        int totalPage = (totalRecord  +  pageSize  - 1) / pageSize;
        map.put("totalPage", totalPage);
        int startIndex = (pageNo - 1) * pageSize;
        List<Blog> blogs = blogDao.getBlogs(startIndex, pageSize);
        map.put("blogs", blogs);
        return map;
    }

    public boolean addBlog(Blog blog) {
        return blogDao.insert(blog);
    }
}
