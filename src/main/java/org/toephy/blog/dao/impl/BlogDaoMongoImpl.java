package org.toephy.blog.dao.impl;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;
import org.toephy.blog.bean.entity.mongo.BlogMongo;
import org.toephy.blog.dao.IBlogMongoDao;
import org.toephy.blog.datasource.MongoClientFactory;

import java.util.List;

/**
 * Created by Toephy on 2017.5.2 15:40
 */
@Repository
public class BlogDaoMongoImpl implements IBlogMongoDao {

    @Override
    public BlogMongo getBlogbyId(int id) {
        Morphia morphia = new Morphia();
        Datastore ds = morphia.createDatastore(MongoClientFactory.getClient(), BlogMongo.getDbName());

        Query<BlogMongo> query = ds.createQuery(BlogMongo.class).filter("blogId", id);
        return query.get();
    }

    @Override
    public List<BlogMongo> getBlogListByIds(List<Integer> ids) {
        Morphia morphia = new Morphia();
        Datastore ds = morphia.createDatastore(MongoClientFactory.getClient(), BlogMongo.getDbName());

        Query<BlogMongo> query = ds.createQuery(BlogMongo.class).field("blogId").in(ids);
        return query.asList();
    }

    @Override
    public boolean saveBlogContent(BlogMongo blog) {
        Morphia morphia = new Morphia();
        Datastore ds = morphia.createDatastore(MongoClientFactory.getClient(), BlogMongo.getDbName());
        ds.save(blog);
        return true;
    }

}
