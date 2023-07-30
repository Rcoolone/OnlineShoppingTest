package com.rcoolone.onlineshoppingtest.controller;

import com.rcoolone.onlineshoppingtest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    User defaultUser;
    Map<String, User> userMap = new HashMap<>();

    @PostMapping("/users")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            Map<String, Object> resultMap) {

        User user = new User(name, email);
        userMap.put(name, user);
        resultMap.put("user", user);
        return "user_detail";
    }

    @GetMapping("/users/{userName}")
    public String getUser(
            @PathVariable("userName") String userName,
            Map<String, Object> resultMap) {
        User user = userMap.getOrDefault(userName, defaultUser);
        resultMap.put("user", user);
        return "user_detail";
    }

    @PutMapping("/users")
    public User updateUser(
            @RequestParam("userName") String name,
            @RequestParam("email") String email) {

        User user = userMap.get(name);
        user.setEmail(email);
        userMap.put(name, user);
        return user;
    }

    @DeleteMapping("/users/{userName}")
    public String deleteUser(
            @PathVariable("userName") String name,
            Map<String, Object> resultMap) {

        User user = userMap.remove(name);
        resultMap.put("user", user);
        return "user_detail";
    }
}
