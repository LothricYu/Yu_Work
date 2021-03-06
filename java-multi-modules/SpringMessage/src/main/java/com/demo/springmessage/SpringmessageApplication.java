package com.demo.springmessage;

import com.demo.springmessage.filter.LoginFilte;
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
        registration.addUrlPatterns("/Show","/AddMessage","/querymessagebyusername","/addmessage","/message_new","/message_edit","/message_updata","/message_delete","/useredit","/user_updata");
        registration.setName("TestFilter");
        return registration;
    }
}
