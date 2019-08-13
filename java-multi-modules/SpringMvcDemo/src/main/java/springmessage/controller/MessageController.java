package springmessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springmessage.pojo.Message;
import springmessage.pojo.User;
import springmessage.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

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

    @RequestMapping("/addmessage")
    public String tonewmessagePage(){
        return "AddMessage";
    }

    @RequestMapping("/message_new")
    public String insertMessage(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
//        Message message = new Message();
//        message.setTitle(title);
//        message.setContent(content);
//        message.setUserId(user.getId());
        if (messageService.insertMessage(title,content,user.getId())){
            return "redirect:/Show?page=1";
        }
        return null;
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
            return "redirect:/Show?page=1";
        }
        System.out.println("fail");
        return "null";
    }

    @RequestMapping("/message_delete")
    public String deleteMessageById(HttpServletRequest request){
        int messageId = Integer.parseInt(request.getParameter("deleteid"));
        if (messageService.deleteMessage(messageId)){
            return "redirect:/Show?page=1";
        }
        return "null";
    }

}
