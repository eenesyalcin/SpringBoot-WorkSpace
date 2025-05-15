package com.enesyalcin.config;

import com.enesyalcin.model.User;
import com.enesyalcin.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(){
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User("Enes"));
        userList.add(new User("Sena"));

        userService.setUserList(userList);

        return userService;
    }


}
