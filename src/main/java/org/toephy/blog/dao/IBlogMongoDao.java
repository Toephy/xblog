package org.toephy.blog.dao;

import org.toephy.blog.bean.entity.mongo.BlogMongo;

import java.util.List;

/**
 * Created by Toephy on 2017.5.2 15:42
 */
public interface IBlogMongoDao {

    BlogMongo getBlogbyId(int id);

    List<BlogMongo> getBlogListByIds(List<Integer> ids);

    boolean saveBlogContent(BlogMongo blog);
}
