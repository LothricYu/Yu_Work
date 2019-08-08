package com.demo.springmessage;

import com.demo.springmessage.pojo.User;
import com.demo.springmessage.service.MessageService;
import com.demo.springmessage.service.PermissionService;
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
    @Autowired
    PermissionService permissionService;

    @Test
    public void contextLoads() {
        User user = userService.findByUsername("jack");

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

//        Message message = new Message();
//        message.setTitle("qq");
//        message.setContent("qq");
//        message.setUserId(1);
//        messageService.insertMessage(message);




//        permissionService.updatepermission(1,1,1,1,1,1,1,1,1,3);

//        Permission permission=new Permission();
//        permission=permissionService.permissionByname("robot2");
//        int p=permission.getUpdate_user_all();
//        System.out.println(p);






        User user=new User();
        user.setTel("111");
        user.setPassword("222");
        user.setUsername("Fu");
        user.setEmail("113141");
        userService.insertUser(user);

//        Permission permission=new Permission();
//        permission.
    }

}
