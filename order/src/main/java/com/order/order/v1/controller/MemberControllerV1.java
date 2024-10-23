package com.order.order.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberControllerV1 {

    @RequestMapping("/v1/member")
    public String Member(){
        return "/v1/member/member";
    }

}
