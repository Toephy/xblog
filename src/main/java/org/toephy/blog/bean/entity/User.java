package org.toephy.blog.bean.entity;

import java.util.Date;

/**
 * Created by Toephy on 2017.4.25 14:48
 */
public class User {

    private int id;             //本地用户id
    private String openId;      //用户第三方唯一标识
    private String nickname;    //昵称
    private String avatarurl;   //头像地址
    private int regesterType;   //第三方用户来源 1:QQ 2:weixin 3:weibo
    private Date createTime;    //记录创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public int getRegesterType() {
        return regesterType;
    }

    public void setRegesterType(int regesterType) {
        this.regesterType = regesterType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
