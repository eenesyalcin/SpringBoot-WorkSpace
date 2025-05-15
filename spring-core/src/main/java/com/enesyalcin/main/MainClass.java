package com.enesyalcin.main;

import com.enesyalcin.config.AppConfig;
import com.enesyalcin.model.User;
import com.enesyalcin.services.LoginService;
import com.enesyalcin.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public  static  void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        for (User user: userService.getUserList()){
            System.out.println(user);
        }

        LoginService loginService = new LoginService();
        loginService.login();

    }

}
