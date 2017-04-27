package org.toephy.blog.bean.dto;

import org.toephy.blog.bean.entity.User;

import java.util.Date;

/**
 * Created by Toephy on 2017.4.27 16:26
 */
public class GuestNoteDto {
    private int id;
    private User user;
    private String content;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
