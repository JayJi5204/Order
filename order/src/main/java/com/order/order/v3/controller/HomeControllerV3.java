package com.order.order.v3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v3")
public class HomeControllerV3 {

    @GetMapping("/home")
    public String getHome(){
        return "/v3/home/home";
    }
    @PostMapping("/home")
    public String postHome(){
        return "/v3/home/home";
    }
}
