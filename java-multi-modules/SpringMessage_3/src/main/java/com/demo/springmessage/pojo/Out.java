package com.demo.springmessage.pojo;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class Out {
    public void seprint(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('更新成功');window.location.href='showalluser';</script>");
    }

    public void feprint(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('更新失败');window.location.href='showalluser';</script>");
    }

    public void print(ServletResponse response,String message) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('修改成功');window.location.href='showalluser';</script>");
    }
}
