package com.order.order.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class HomeControllerV2 {

    @GetMapping("/home")
    public String getHome(){
        return "/v2/home/home";
    }
    @PostMapping("/home")
    public String postHome(){
        return "/v2/home/home";
    }
}
