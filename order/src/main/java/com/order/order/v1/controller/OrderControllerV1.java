package com.order.order.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderControllerV1 {
    @RequestMapping("/v1/order")
    public String order(){
        return "/v1/order/order";
    }
}
