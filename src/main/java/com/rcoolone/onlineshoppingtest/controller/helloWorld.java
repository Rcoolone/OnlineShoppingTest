package com.rcoolone.onlineshoppingtest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("/test/{text}")
    public String hello(@PathVariable("text") String text) {
        return text;
    }
}
