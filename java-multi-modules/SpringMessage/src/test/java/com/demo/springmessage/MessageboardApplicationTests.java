package com.demo.springmessage;

import com.demo.springmessage.entity.Message;
import com.demo.springmessage.entity.User;
import com.demo.springmessage.service.MessageService;
import com.demo.springmessage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageboardApplicationTests {
    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Test
    public void contextLoads() {
        User user = userService.findByUsername("jack");
        System.out.println(user.toString());

//        user.setEmail("xx");
//        boolean b = userService.updateUser(user);
//        System.out.println(b);
//        User user1 = userService.findByUsername("jack");
//        System.out.println(user1.toString());
    }

    @Test
    public void testmessageDao() {
//        List<Message> all = messageService.selectMessageByUsername("jack");
//        for (Message m : all){
//            System.out.println(m.toString());
//        }

//       Message all = messageService.selectMessageById(6);
//       System.out.println(all);
//        boolean b = messageService.updateMessage(6, "1", "1");

        Message message = new Message();
        message.setTitle("qq");
        message.setContent("qq");
        message.setUserId(1);
        messageService.insertMessage(message);
    }

}
