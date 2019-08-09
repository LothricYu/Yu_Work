package com.demo.springmessage;

import com.demo.springmessage.filter.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringmessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmessageApplication.class, args);
    }
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilte());
        registration.addUrlPatterns("/showalluser","/Show","/AddMessage","/querymessagebyusername","/addmessage","/message_new","/message_edit","/message_updata","/message_delete","/useredit","/user_updata","/vis_per","/role_permission","/user_role","/user_roleup","/alluseredit","/no","/vis","/ad","/normal_per","/ad_per");
        registration.setName("TestFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean updatefilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new updatefilter());
        registration.addUrlPatterns("/message_edit");
        registration.setName("updateFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean deletefilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new deleteFilter());
        registration.addUrlPatterns("/message_delete");
        registration.setName("deletefilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean editefilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new editpersonfilter());
        registration.addUrlPatterns("/useredit");
        registration.setName("editfilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean addmefilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new addmFilter());
        registration.addUrlPatterns("/addmessage");
        registration.setName("addmfilter");
        return registration;
    }
}
