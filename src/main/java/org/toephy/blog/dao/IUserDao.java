package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.toephy.blog.bean.entity.User;

/**
 * Created by Toephy on 2017.4.25 15:14
 */
@Mapper
public interface IUserDao {

    /**
     * 插入用户，返回用户id
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 通过openid查询用户
     * @param openId
     * @return
     */
    User getUserByOpenId(String openId);

    /**
     * 通过id查询用户
     * @param openId
     * @return
     */
    User getUserById(int id);

}
