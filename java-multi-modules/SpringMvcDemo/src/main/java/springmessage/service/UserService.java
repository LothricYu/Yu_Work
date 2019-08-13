package springmessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmessage.dao.UserDao;
import springmessage.pojo.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public boolean insertUser(User user) {
        return userDao.insertUser(user) > 0 ? true : false;
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public boolean updateUser(User user){
        return  userDao.updateUser(user) >0? true:false;
    }

    public boolean updateUserrole(int id,int roleid){
        return  userDao.updateuserrole(id,roleid) >0? true:false;
    }

    public boolean A_updateuser(String username,String password,String email,String tel,int groupid,int id){
        return  userDao.A_updateuser(username,password,email,tel,groupid,id) >0? true:false;
    }

    public boolean deleteUser(int userid) {
        return userDao.deleteUser(userid) > 0 ? true : false;
    }
}