package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Select("select username,id,username,password,email,telnumber,photo,groupid,roleid,(select count(*) from message where userid=id) as count from user where username=#{username}")
    @Results(id = "userResultMap",value = {
            @Result(column="id", property="id"),
            @Result(column="username", property="username"),
            @Result(column="password", property="password"),
            @Result(column="email", property="email"),
            @Result(column="telnumber", property="tel"),
            @Result(column="photo", property="photo_path"),
            @Result(column = "groupid",property = "groupid"),
            @Result(column = "roleid",property = "roleid"),
            @Result(column="count", property="messageNum"),
    })
    User findByUsername(String username);

    @Update("update user set username=#{username}, password=#{password},email=#{email},telnumber=#{tel} where id=#{id}")
    int updateUser(User user);

    @Update("update user set photo=#{photo_path} where id=#{id}")
    int updateUserPhoto(String photo_path,int id);

    @Select("select username,id,username,password,email,telnumber,groupid,roleid,(select count(*) from message where userid=id) as count from user ")
    @Results(id = "userallMap",value = {
            @Result(property="id",column="id"),
            @Result(property="username",column="username"),
            @Result(property="password",column="password"),
            @Result(property="email",column="email"),
            @Result(property="tel",column="telnumber"),
            @Result(property="groupid",column="groupid"),
            @Result(property="roleid",column="roleid"),
            @Result(property="messageNum",column="count"),
    })
     List<User> findAll();

    @Delete("delete from user where id=#{userid}")
    int deleteUser(int userid);

    @Insert("insert into user(username,password,email,telnumber) value(#{username},#{password},#{email},#{tel})")
    int insertUser(User user);

    @Update("update user set roleid=#{roleid} where id=#{id}")
    int updateuserrole(int id, int roleid);

    @Update("update user set username=#{username}, password=#{password},email=#{email},telnumber=#{tel},groupid=#{groupid} where id=#{id}")
    int A_updateuser(String username,String password,String email,String tel,int groupid,int id);

}
