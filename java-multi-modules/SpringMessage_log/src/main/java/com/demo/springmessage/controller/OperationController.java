package com.demo.springmessage.controller;

import com.demo.springmessage.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OperationController {

    @Autowired
    OperationService operationService;

    @RequestMapping("/operationshow")
    public String operationshow(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));
        List list=operationService.findfenyeOperation(page);
        int count = operationService.pageNum();
        request.setAttribute("count",count);
        request.setAttribute("operationList",list);
        request.setAttribute("page",page);
        return "operationshow";
    }

    @RequestMapping("/queryoperationbyusername")
    public String queryMessageByUsername(HttpServletRequest request){
        String username = request.getParameter("username");
        List list = operationService.queryoperationByUsername(username);
        request.setAttribute("operationList",list);
        request.setAttribute("page",1);
        return "operationshow";
    }
}
