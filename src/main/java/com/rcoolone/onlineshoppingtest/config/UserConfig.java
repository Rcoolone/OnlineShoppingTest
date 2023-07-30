package com.rcoolone.onlineshoppingtest.config;

import com.rcoolone.onlineshoppingtest.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User getUser() {
        return new User("No Such User", "Please Check Again");
    }
}
