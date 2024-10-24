package com.order.order.v2.controller;

import com.order.order.v2.service.OrderListServiceV2;
import com.order.order.v2.vo.OrderListVo;
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
public class OrderListControllerV2 {
    @Autowired
    OrderListServiceV2 orderListServiceV2;

    @RequestMapping("/order")
    public String doOrder(Model model) {
        List<OrderListVo> list = orderListServiceV2.doListAll();
        model.addAttribute("list", list);
        return "/v2/order/order";
    }

    @PostMapping("/order_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "item", defaultValue = "ALL") String item, @RequestParam(value = "name", defaultValue = "ALL") String name, Model model) {
        List<OrderListVo> list = orderListServiceV2.doSearch(startDate, endDate, item, name);
        model.addAttribute("list", list);
        return "/v2/order/order";
    }
}
