package com.order.order.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeController {


    @GetMapping("/home")
    public String getHome(){

        return "/v1/home/home";
    }
    @PostMapping("/home")
    public String postHome(){

        return "/v1/home/home";
    }
}