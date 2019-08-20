package com.demo.springmessage.service;

import com.demo.springmessage.aop.MyLog;
import com.demo.springmessage.dao.MessageDao;
import com.demo.springmessage.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @MyLog(value="查询留言列表")
    public List<Message> findfenyeMessage(int page) {
        int begin = (page - 1) * 10;
        int end =  10;
//        System.out.println(begin);
//        System.out.println(end);
        return messageDao.findfenyeMessage(begin,end);
    }

    public int pageNum(){
        return messageDao.selectTotalNum();
    }


    @MyLog(value="查看留言内容")
    public Message selectMessageById(int message_id) {
        return messageDao.selectMessageById(message_id);
    }

    @MyLog(value="通过用户名查询留言")
    public List<Message> selectMessageByUsername(String username) {
        return messageDao.selectMessageByUsername(username);
    }
    @MyLog(value="修改留言")
    public boolean updateMessage(int id, String title, String content) {
        return messageDao.updateMessage(id, title, content) > 0 ? true : false;
    }
    @MyLog(value="删除留言")
    public boolean deleteMessage(int messageid) {
        return messageDao.deleteMessage(messageid) > 0 ? true : false;
    }
    @MyLog(value="添加留言")
    public boolean insertMessage(Message message) {
        return messageDao.insertMessage(message) > 0 ? true : false;
    }

}
