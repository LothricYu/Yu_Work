package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.BillDao;
import com.demo.springmessage.dao.UserDao;
import com.demo.springmessage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BillDao billDao;

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

    @MyLog(value = "充值")
    public boolean chongzhi(Double number,int id){
        return  userDao.updateUserBalance(number,id) >0? true:false;
    }

    @MyLog(value = "打赏")
    @Transactional
    public boolean reward(int userId,Double moneyNum,int messageUserId) throws IOException {//打赏者id，打赏金额，被打赏者id
        int result1 = userDao.reduceUserBalance(moneyNum,userId);
        int result2 = userDao.addUserBalance(moneyNum,messageUserId);
        if (result1 * result2 == 1){
            int temp = (int)(Math.random()*100);
            if (temp % 2 == 0){
                System.out.println("成功");
                return true;
            }
            else{
                throw new RuntimeException("异常");
            }
        }
        return false;
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
