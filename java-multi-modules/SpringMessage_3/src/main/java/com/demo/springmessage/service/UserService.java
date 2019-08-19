package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.UserDao;
import com.demo.springmessage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @MyLog(value="查看用户列表")
    public List<User> findAll() {
        return userDao.findAll();
    }
    @MyLog(value="添加用户")
    public boolean insertUser(User user) {
        return userDao.insertUser(user) > 0 ? true : false;
    }

    @MyLog(value="登录")
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    @MyLog(value="退出登录")
    public String loginout(){
        return "退出";
    }


    @MyLog(value="修改个人信息")
    public boolean updateUser(User user){
        return  userDao.updateUser(user) >0? true:false;
    }

    @MyLog(value="修改用户角色")
    public boolean updateUserrole(int id,int roleid){
        return  userDao.updateuserrole(id,roleid) >0? true:false;
    }

    @MyLog(value="修改用户信息")
    public boolean A_updateuser(String username,String password,String email,String tel,int groupid,int id){
        return  userDao.A_updateuser(username,password,email,tel,groupid,id) >0? true:false;
    }
    @MyLog(value="删除用户")
    public boolean deleteUser(int userid) {
        return userDao.deleteUser(userid) > 0 ? true : false;
    }
}
