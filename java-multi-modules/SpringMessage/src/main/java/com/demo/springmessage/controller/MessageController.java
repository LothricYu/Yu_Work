package com.demo.springmessage.controller;

import com.demo.springmessage.pojo.Message;
import com.demo.springmessage.pojo.User;
import com.demo.springmessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/newmessage")
    public String tonewmessagePage(){
        return "AddMessage";
    }

    @RequestMapping("/Show")
    public String queryAllMessage(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));
        String name=request.getParameter("username");
        List list = messageService.findfenyeMessage(page);
        int count = messageService.pageNum();
        request.setAttribute("count",count);
        request.setAttribute("messageList",list);
        request.setAttribute("page",page);
        request.setAttribute("username",name);
        return "Show";
    }

    @RequestMapping("/querymessagebyusername")
    public String queryMessageByUsername(HttpServletRequest request){
        String username = request.getParameter("username");
        List list = messageService.selectMessageByUsername(username);
        request.setAttribute("messageList",list);
        request.setAttribute("page",1);
        return "Show";
    }

    @RequestMapping("/message_edit")
    public String editMessageById(HttpServletRequest request){
        int messageId = Integer.parseInt(request.getParameter("editid"));
        Message message = messageService.selectMessageById(messageId);
        request.setAttribute("message",message);
        return "UpdateMessage";
    }

    @RequestMapping("/message_updata")
    public String updataMessageById(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (messageService.updateMessage(id,title,content)){
            request.setAttribute("msg","修改成功!");
            return "redirect:/Show?page=1";
        }
        System.out.println("fail");
        return "null";
    }

    @RequestMapping("/message_delete")
    public String deleteMessageById(HttpServletRequest request){
        int messageId = Integer.parseInt(request.getParameter("deleteid"));
        if (messageService.deleteMessage(messageId)){
            request.setAttribute("msg","删除成功!");
            return "redirect:/Show?page=1";
        }
        return "null";
    }

    @RequestMapping("/message_new")
    public String insertMessage(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        message.setUserId(user.getId());
        if (messageService.insertMessage(message)){
            request.setAttribute("msg","留言成功!");
            return "redirect:/Show?page=1";
        }
        return null;
    }
}
