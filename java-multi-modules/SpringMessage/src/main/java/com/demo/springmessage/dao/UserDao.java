package com.demo.springmessage.dao;

import com.demo.springmessage.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select username,id,username,password,email,telnumber,(select count(*) from message where userid=id) as count from user where username=#{username}")
    @Results(id = "userResultMap",value = {
            @Result(column="id", property="id"),
            @Result(column="username", property="username"),
            @Result(column="password", property="password"),
            @Result(column="email", property="email"),
            @Result(column="telnumber", property="tel"),
            @Result(column="count", property="messageNum"),
    })
    User findByUsername(String username);

    @Update("update user set username=#{username}, password=#{password},email=#{email},telnumber=#{tel} where id=#{id}")
    int updateUser(User user);

}
