package com.demo.springmessage.service;

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

    public List<Message> findfenyeMessage(int page) {
        int begin = (page - 1) * 10;
        int end = begin + 10;
        return messageDao.findfenyeMessage(begin,end);
    }

    public int pageNum(){
        return messageDao.selectTotalNum();
    }

    public Message selectMessageById(int message_id) {
        return messageDao.selectMessageById(message_id);
    }

    public List<Message> selectMessageByUsername(String username) {
        return messageDao.selectMessageByUsername(username);
    }

    public boolean updateMessage(int id, String title, String content) {
        return messageDao.updateMessage(id, title, content) > 0 ? true : false;
    }

    public boolean deleteMessage(int messageid) {
        return messageDao.deleteMessage(messageid) > 0 ? true : false;
    }

    public boolean insertMessage(Message message) {
        return messageDao.insertMessage(message) > 0 ? true : false;
    }

}
