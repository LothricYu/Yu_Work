package com.demo.springmessage.controller;

import com.demo.springmessage.pojo.User;
import com.demo.springmessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Login")
    public String toLoginPage(){
        return "LoginPage";
    }

    @RequestMapping("/useredit")
    public String tousereditPage(){
        return "UpdateUser";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "LoginPage";
    }

    @RequestMapping("/checklogin")
    public String checkLogin(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username",username);

        User user = null;
        user = userService.findByUsername(username);
        if(user.getPassword().equals(password)){
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("user_name",username);
            return "redirect:/Show?page=1";
        }
        return "LoginPage";
    }

    @RequestMapping("/user_updata")
    public String updataUser(HttpServletRequest request){
        User user = new User();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);

        if (userService.updateUser(user)){
            request.getSession().invalidate();
            return "LoginPage";
        }
        return null;
    }
}
