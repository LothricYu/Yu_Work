package com.demo.springmessage;

import com.demo.springmessage.service.*;
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
    @Autowired
    BillService billService;

    @Test
    public void contextLoads() {
        billService.insertBill("充值",20.5,1);
        System.out.println("成功");

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
