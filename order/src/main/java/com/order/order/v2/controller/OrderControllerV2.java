package com.order.order.v2.controller;

import com.order.order.v2.service.OrderServiceV2;
import com.order.order.v2.vo.OrderVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/v2")
@Log4j2
public class OrderControllerV2 {
    @Autowired
    OrderServiceV2 orderServiceV2;

    @RequestMapping("/order")
    public String doOrder(Model model) {
        List<OrderVo> list = orderServiceV2.doListAll();
        model.addAttribute("list", list);
        return "/v2/order/order";
    }

    @PostMapping("/order_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "coffee", defaultValue = "ALL") String coffee, @RequestParam(value = "name", defaultValue = "ALL") String name, Model model) {
        List<OrderVo> list = orderServiceV2.doSearch(startDate, endDate, coffee, name);
        model.addAttribute("list", list);
        return "/v2/order/order";
    }
}
