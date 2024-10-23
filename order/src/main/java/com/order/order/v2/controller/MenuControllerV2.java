package com.order.order.v2.controller;

import com.order.order.v2.service.MenuServiceV2;
import com.order.order.v2.vo.MenuVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/v2")
@Log4j2
public class MenuControllerV2 {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    MenuServiceV2 menuServiceV2;

    @RequestMapping("/menu")
    public String doMenu(Model model) {
        List<MenuVo> list = menuServiceV2.doListAll();
        model.addAttribute("list",list);
        return "/v2/menu/menu";
    }

    // 등록하기
    @GetMapping("/menu_insert")
    public String getDoInsert() {
        return "/v2/menu/menu_insert";
    }

    @PostMapping("/menu_insert")
    public String postDoInsert(@ModelAttribute MenuVo menuVo) {
        menuServiceV2.doInsert(menuVo);
        return "redirect:/v2/menu";
    }

    // 삭제하기
    @GetMapping("/menu_delete")
    public String getDoDelete(@RequestParam("no") String no) {
        menuServiceV2.doDelete(no);
        return "redirect:/v2/menu";
    }

    // 수정하기
    @GetMapping("/menu_update")
    public String getDoUpdate(@RequestParam("no") String no, Model model) {
        Map<String, Object> map = menuServiceV2.doListOne(no);
        model.addAttribute("map", map);
        return "/v2/menu/menu_update";
    }

    @PostMapping("/menu_update")
    public String postDoUpdate(@ModelAttribute MenuVo menuVo) {
        menuServiceV2.doUpdate(menuVo);
        return "redirect:/v2/menu";
    }

    // 조회하기
    @PostMapping("/menu_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "coffee", defaultValue = "ALL") String coffee, @RequestParam("kind") String kind, Model model) {
        List<MenuVo> list = menuServiceV2.doSearch(startDate, endDate, coffee, kind);
        model.addAttribute("list", list);
        return "/v2/menu/menu";
    }

    // 다중 가격 수정
    @PostMapping("/updatePrice")
    public String postDoUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList, @RequestParam("hidden_price") String price) {
        if (chkList != null) {
            menuServiceV2.doUpdatePrice(chkList, price);
        }
        return "redirect:/v2/menu";
    }
}
