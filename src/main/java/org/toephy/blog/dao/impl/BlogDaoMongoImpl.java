package org.toephy.blog.dao.impl;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;
import org.toephy.blog.bean.entity.mongo.BlogMongo;
import org.toephy.blog.dao.IBlogMongoDao;
import org.toephy.blog.datasource.MongoClientFactory;

/**
 * Created by Toephy on 2017.5.2 15:40
 */
@Repository
public class BlogDaoMongoImpl implements IBlogMongoDao {

    @Override
    public BlogMongo getBlogbyId(int id) {
        try {
            Morphia morphia = new Morphia();
            Datastore ds = morphia.createDatastore(MongoClientFactory.getClient(), BlogMongo.getDbName());

            Query<BlogMongo> query = ds.createQuery(BlogMongo.class).filter("blogId", id);
            return query.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
