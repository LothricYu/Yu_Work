package com.demo.springmessage.service;

import com.demo.springmessage.dao.UserDao;
import com.demo.springmessage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public boolean updateUser(User user){
        return  userDao.updateUser(user) >0? true:false;
    }
}
