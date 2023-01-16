package com.everyday_coding.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/register")
    public String registerView() {
        return "register";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

}
