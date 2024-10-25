package com.order.order.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerV1 {

    // 메인 화면
    @RequestMapping("/v1/home")
    public String getHome(){
        return "/v1/home/home";
    }
}
