package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","hello world");
        return "no";
    }




}
