package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.toephy.blog.bean.entity.Blog;
import org.toephy.blog.bean.entity.mongo.BlogMongo;
import org.toephy.blog.dao.IBlogDao;
import org.toephy.blog.dao.IBlogMongoDao;
import org.toephy.blog.service.IBlogService;

import java.util.ArrayList;
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
    @Autowired
    private IBlogMongoDao blogMongoDao;

    @Override
    public Blog getBlogById(int id) {
        Blog blog = blogDao.getBlogbyId(id);
        BlogMongo blogMongo = blogMongoDao.getBlogbyId(blog.getId());
        if (blogMongo == null) {
            return null;
        }
        blog.setBlogDesc(blogMongo.getBlogDesc());
        blog.setBlogContent(blogMongo.getBlogContent());
        return blog;
    }

    public Map<String, Object> blogList(int pageNo, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        int totalRecord = blogDao.getCount();
        int totalPage = (totalRecord  +  pageSize  - 1) / pageSize;
        map.put("totalPage", totalPage);
        int startIndex = (pageNo - 1) * pageSize;
        List<Blog> blogs = blogDao.getBlogs(startIndex, pageSize);

        if (!CollectionUtils.isEmpty(blogs)) {
            List<Integer> ids = new ArrayList<Integer>();
            Map<Integer, Blog> blogMap = new HashMap<Integer, Blog>();
            for (Blog item : blogs) {
                ids.add(item.getId());
                blogMap.put(item.getId(), item);
            }

            // 从mongo中查询blog的描述和内容
            List<BlogMongo> blogMongoList = blogMongoDao.getBlogListByIds(ids);
            if (!CollectionUtils.isEmpty(blogMongoList)) {
                for (BlogMongo blogMongo : blogMongoList) {
                    Blog blog = blogMap.get(blogMongo.getBlogId());
                    if (blog != null) {
                        blog.setBlogDesc(blogMongo.getBlogDesc());
                        blog.setBlogContent(blogMongo.getBlogContent());
                    }
                }
            }
        }

        map.put("blogs", blogs);
        return map;
    }

    public boolean addBlog(Blog blog) {
        try {
            // 在mysql中存储博客基础信息
            blogDao.insert(blog);

            // 在mongo中存储博客简介和内容
            BlogMongo blogMongo = new BlogMongo();
            blogMongo.setBlogId(blog.getId());
            blogMongo.setBlogDesc(blog.getBlogDesc());
            blogMongo.setBlogContent(blog.getBlogContent());
            blogMongoDao.saveBlogContent(blogMongo);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
