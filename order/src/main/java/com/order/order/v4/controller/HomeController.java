package com.order.order.v4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v4")
public class HomeController {

    @GetMapping("/home")
    public String getHome(){
        return "/v4/home/home";
    }
    @PostMapping("/home")
    public String postHome(){
        return "/v4/home/home";
    }
}
