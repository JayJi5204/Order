package com.order.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping("/v1/member")
    public String Member(){
        return "/v1/member/member";
    }

}
