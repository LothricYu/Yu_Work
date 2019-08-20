package com.demo.springmessage.pojo;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class Out {
    public void seprint(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('操作成功');window.location.href='showalluser';</script>");
    }

    public void feprint(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('操作失败');window.location.href='showalluser';</script>");
    }

    public void dashang_print_se(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('打赏成功');window.location.href='Show?page=1';</script>");
    }

    public void dashang_print_fe(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('打赏失败');window.location.href='Show?page=1';</script>");
    }

    public void dashang_print_fe_same(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<script charset='utf-8' language='javascript' type='text/javascript' >alert('不可打赏自己');window.location.href='Show?page=1';</script>");
    }


}
