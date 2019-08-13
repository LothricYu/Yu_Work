package springmessage.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import springmessage.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Select("select username,id,username,password,email,telnumber,groupid,roleid,(select count(*) from message where userid=id) as count from user where username=#{username}")
    @Results(id = "userResultMap",value = {
            @Result(column="id", property="id"),
            @Result(column="username", property="username"),
            @Result(column="password", property="password"),
            @Result(column="email", property="email"),
            @Result(column="telnumber", property="tel"),
            @Result(column = "groupid",property = "groupid"),
            @Result(column = "roleid",property = "roleid"),
            @Result(column="count", property="messageNum"),
    })
    User findByUsername(String username);

    @Update("update user set username=#{username}, password=#{password},email=#{email},telnumber=#{tel} where id=#{id}")
    int updateUser(User user);

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
    int deleteUser(@Param("userid")int userid);

    @Insert("insert into user(username,password,email,telnumber) value(#{username},#{password},#{email},#{tel})")
    int insertUser(User user);

    @Update("update user set roleid=#{roleid} where id=#{id}")
    int updateuserrole(@Param("id")int id, @Param("roleid")int roleid);

    @Update("update user set username=#{username}, password=#{password},email=#{email},telnumber=#{tel},groupid=#{groupid} where id=#{id}")
    int A_updateuser(@Param("username") String username,
                     @Param("password") String password,
                     @Param("email")String email,
                     @Param("tel") String tel,
                     @Param("groupid")int groupid,
                     @Param("id")int id);

}
