package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toephy.blog.bean.entity.User;
import org.toephy.blog.dao.IUserDao;
import org.toephy.blog.service.IUserService;

/**
 * Created by Toephy on 2017.4.25 15:26
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userDao.getUserByOpenId(openId);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

}
