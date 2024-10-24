package com.order.order.v1.controller;

import com.order.order.v1.service.ItemInfoServiceV1;
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
public class ItemInfoControllerV1 {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    ItemInfoServiceV1 itemInfoServiceV1;

    @RequestMapping("/item")
    public String item(Model model) {
        List<Map<String, Object>> list = itemInfoServiceV1.doListAll();
        // Data 보내기
        model.addAttribute("list", list);
        return "/v1/item/item";
    }

    // 등록하기
    @GetMapping("/item_insert")
    public String getDoInsert() {
        return "/v1/item/item_insert";
    }

    @PostMapping("/item_insert")
    public String postDoInsert(@RequestParam("item") String item, @RequestParam("kind") String kind, @RequestParam("price") String price) {
        itemInfoServiceV1.doInsert(item, kind, price);
        return "redirect:/v1/item";
    }

    // 삭제하기
    @GetMapping("/item_delete")
    public String getDoDelete(@RequestParam("no") String no) {
        itemInfoServiceV1.doDelete(no);
        return "redirect:/v1/item";
    }

    // 수정하기
    @GetMapping("/item_update")
    public String getDoUpdate(@RequestParam("no") String no, Model model) {
        Map<String, Object> map = itemInfoServiceV1.doListOne(no);
        model.addAttribute("map", map);
        return "/v1/item/item_update";
    }

    @PostMapping("/item_update")
    public String postDoUpdate(@RequestParam("no") String no, @RequestParam("item") String item, @RequestParam("kind") String kind, @RequestParam("price") String price) {
        itemInfoServiceV1.doUpdate(no, item, kind, price);
        return "redirect:/v1/item";
    }

    // 조회하기
    @PostMapping("/item_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "item", defaultValue = "ALL") String item, @RequestParam("kind") String kind, Model model) {
        List<Map<String, Object>> list = itemInfoServiceV1.doSearch(startDate, endDate, item, kind);
        model.addAttribute("list", list);
        return "/v1/item/item";
    }

    // 다중 가격 수정
    @PostMapping("/updatePrice")
    public String postDoUpdatePrice(@RequestParam("chkItemNo") List<String> chkList,@RequestParam("hidden_price") String price){
        if(chkList != null){
                itemInfoServiceV1.doUpdatePrice(chkList,price);
        }
        return "redirect:/v1/item";
    }
}
