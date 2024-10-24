package com.order.order.v2.controller;

import com.order.order.v2.service.ItemInfoServiceV2;
import com.order.order.v2.vo.ItemInfoVo;
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
public class ItemInfoControllerV2 {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    ItemInfoServiceV2 itemInfoServiceV2;

    // 상품 목록 화면
    @RequestMapping("/item")
    public String doItem(Model model) {
        List<ItemInfoVo> list = itemInfoServiceV2.doListAll();
        model.addAttribute("list",list);
        return "/v2/item/item";
    }

    // 등록하기
    @GetMapping("/item_insert")
    public String getDoInsert() {
        return "/v2/item/item_insert";
    }

    @PostMapping("/item_insert")
    public String postDoInsert(@ModelAttribute ItemInfoVo itemInfoVo) {
        itemInfoServiceV2.doInsert(itemInfoVo);
        return "redirect:/v2/item";
    }

    // 삭제하기
    @GetMapping("/item_delete")
    public String getDoDelete(@RequestParam("no") String no) {
        itemInfoServiceV2.doDelete(no);
        return "redirect:/v2/item";
    }

    // 수정하기
    @GetMapping("/item_update")
    public String getDoUpdate(@RequestParam("no") String no, Model model) {
        Map<String, Object> map = itemInfoServiceV2.doListOne(no);
        model.addAttribute("map", map);
        return "/v2/item/item_update";
    }

    @PostMapping("/item_update")
    public String postDoUpdate(@ModelAttribute ItemInfoVo itemInfoVo) {
        itemInfoServiceV2.doUpdate(itemInfoVo);
        return "redirect:/v2/item";
    }

    // 조회하기
    @PostMapping("/item_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "coffee", defaultValue = "ALL") String item, @RequestParam("kind") String kind, Model model) {
        List<ItemInfoVo> list = itemInfoServiceV2.doSearch(startDate, endDate, item, kind);
        model.addAttribute("list", list);
        return "/v2/item/item";
    }

    // 다중 가격 수정
    @PostMapping("/updatePrice")
    public String postDoUpdatePrice(@RequestParam("chkItemNo") List<String> chkList, @RequestParam("hidden_price") String price) {
        if (chkList != null) {
            itemInfoServiceV2.doUpdatePrice(chkList, price);
        }
        return "redirect:/v2/item";
    }
}
