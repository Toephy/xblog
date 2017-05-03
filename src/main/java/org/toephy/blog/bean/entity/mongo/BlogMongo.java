package org.toephy.blog.bean.entity.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Toephy on 2017.5.2 15:34
 */
@Entity(value="blog", noClassnameStored=true)
public class BlogMongo extends BaseMongo {

    @Id
    private ObjectId _id;
    private int blogId;
    private String blogDesc;
    private String blogContent;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
