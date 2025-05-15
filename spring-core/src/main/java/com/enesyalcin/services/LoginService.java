package com.enesyalcin.services;

import com.enesyalcin.config.AppConfig;
import com.enesyalcin.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginService {

    public void login(){
        // User listesine ihtiyacım var.
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println("-----> Login metodu içerisinden erişilen User bilgileri <-----");
        for (User user: userService.getUserList()){
            System.out.println(user);
        }
    }

}
