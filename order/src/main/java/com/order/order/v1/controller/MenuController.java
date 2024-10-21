package com.order.order.v1.controller;

import com.order.order.v1.service.MenuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/v1")
@Log4j2
public class MenuController {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    MenuService menuService;

    @RequestMapping("/menu")
    public String menu(Model model) {
        List<Map<String, Object>> list = menuService.doListAll();
        // Data 보내기
        model.addAttribute("list", list);
        return "/v1/menu/menu";
    }

    // 등록하기
    @GetMapping("/menu_insert")
    public String getDoInsert() {
        return "/v1/menu/menu_insert";
    }

    @PostMapping("/menu_insert")
    public String postDoInsert(@RequestParam("coffee") String coffee, @RequestParam("kind") String kind, @RequestParam("price") String price) {
        menuService.doInsert(coffee, kind, price);
        return "redirect:/v1/menu";
    }

    // 삭제하기
    @GetMapping("/menu_delete")
    public String getDoDelete(@RequestParam("no") String no) {
        menuService.doDelete(no);
        return "redirect:/v1/menu";
    }

    // 수정하기
    @GetMapping("/menu_update")
    public String getDoUpdate(@RequestParam("no") String no, Model model) {
        Map<String, Object> map = menuService.doListOne(no);
        model.addAttribute("map", map);
        return "/v1/menu/menu_update";
    }

    @PostMapping("/menu_update")
    public String postDoUpdate(@RequestParam("no") String no, @RequestParam("coffee") String coffee, @RequestParam("kind") String kind, @RequestParam("price") String price) {
        menuService.doUpdate(no, coffee, kind, price);
        return "redirect:/v1/menu";
    }

    // 조회하기
    @PostMapping("/menu_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "coffee", defaultValue = "ALL") String coffee, @RequestParam("kind") String kind, Model model) {
        List<Map<String, Object>> list = menuService.doSearch(startDate, endDate, coffee, kind);
        model.addAttribute("list", list);
        return "/v1/menu/menu";
    }
}
