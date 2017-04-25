package org.toephy.blog.service;

import org.toephy.blog.bean.entity.User;

/**
 * Created by Toephy on 2017.4.25 15:25
 */
public interface IUserService {

    int addUser(User user);

    User getUserByOpenId(String openId);

    User getUserById(int id);
}
