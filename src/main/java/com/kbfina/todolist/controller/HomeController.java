package com.kbfina.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/")
    public String Home(){
        return "Hello Spring Boot-Quyen Kbfina";
    }
}

