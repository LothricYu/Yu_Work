package com.demo.springmessage.dao;

import com.demo.springmessage.pojo.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageDao {
    @Select("select m_id,m_title,m_detail,starttime,edittime,userid,username,groupid from message inner join user on userid = id")
    @Results(id = "messageResultMap",value = {
            @Result(property="id",column="m_id"),
            @Result(property="title",column="m_title"),
            @Result(property="content",column="m_detail"),
            @Result(property="createTime",column="starttime"),
            @Result(property="editTime",column="edittime"),
            @Result(property="userId",column="userid"),
            @Result(property="writer",column="username"),
            @Result(property="m_groupid",column="groupid")
    })
    List<Message> findAll();

    @Insert("insert into message(m_title,m_detail,userid,starttime,edittime) value(#{title},#{content},#{userId},NOW(),NOW())")
    int insertMessage(Message message);
    //分页查询
    @Select("select m_id,m_title,m_detail,starttime,edittime,userid,username,groupid from message inner join user on userid = id limit #{begin},#{end}")
    @ResultMap("messageResultMap")
    List<Message> findfenyeMessage(int begin, int end);

    @Select("select count(m_id) from message")
    int selectTotalNum();

    @Select("select m_id,m_title,m_detail,starttime,edittime,userid,username,groupid from message inner join user on userid = id where m_id=#{message_id}")
    @ResultMap("messageResultMap")
    Message selectMessageById(int message_id);

    @Select("select m_id,m_title,m_detail,starttime,edittime,userid,username,groupid from message inner join user on userid = id where user.username=#{username}")
    @ResultMap("messageResultMap")
    List<Message> selectMessageByUsername(String username);

    @Update("update message set m_title=#{title}, m_detail=#{content},edittime=NOW() where m_id=#{id}")
    int updateMessage(int id, String title, String content);

    @Delete("delete from message where m_id=#{messageid}")
    int deleteMessage(int messageid);

}
