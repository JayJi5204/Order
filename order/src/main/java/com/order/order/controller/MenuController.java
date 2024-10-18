package com.order.order.controller;

import com.order.order.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@Controller
public class MenuController {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    MenuService menuService;

    @RequestMapping("/v1/menu")
    public String menu(Model model) {

        List<Map<String, Object>> list = menuService.doList();

        // Data 보내기
        model.addAttribute("list", list);
        return "/v1/menu/menu";
    }
}
