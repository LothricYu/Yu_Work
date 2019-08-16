package com.demo.springmessage;

import com.demo.springmessage.pojo.User;
import com.demo.springmessage.service.MessageService;
import com.demo.springmessage.service.OperationService;
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
    @Autowired
    OperationService operationService;

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

    }

}
