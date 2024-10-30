//package com.order.order.v4.controller;
//
//import com.order.order.v3.service.OrderListServiceV3;
//import com.order.order.v3.vo.OrderListVo;
//import com.order.order.v4.service.ItemInfoService;
//import com.order.order.v4.service.OrderService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/v3")
//@Log4j2
//public class OrderListController {
//    @Autowired
//    OrderService orderService;
//
//    // 주문 목록 화면
//    @RequestMapping("/order")
//    public String doOrder(Model model) {
//        List<OrderListVo> list = orderService.getAllOrder();
//        model.addAttribute("list", list);
//        return "/v3/order/order";
//    }
//
//    // 조회하기
//    @PostMapping("/order_search")
//    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "item", defaultValue = "ALL") String item, @RequestParam(value = "name", defaultValue = "ALL") String name, Model model) {
//        List<OrderListVo> list = orderService.searchOrder(startDate, endDate, item, name);
//        model.addAttribute("list", list);
//        return "/v3/order/order";
//    }
//}
