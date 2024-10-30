package com.order.order.v3.controller;

import com.order.order.v3.service.ItemInfoServiceV3;
import com.order.order.v3.vo.ItemInfoVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/v3")
@Log4j2
public class ItemInfoControllerV3 {

    @Autowired // IoC 컨테이너에서 가져옴(재사용), Service에 의존한다(Dependency)
    ItemInfoServiceV3 itemInfoServiceV3;

    // 상품 목록 화면
    @RequestMapping("/item")
    public String doItem(Model model) {
        List<ItemInfoVo> list = itemInfoServiceV3.doListAll();
        model.addAttribute("list",list);
        return "/v3/item/item";
    }

    // 등록하기
    @GetMapping("/item_insert")
    public String getDoInsert() {
        return "/v3/item/item_insert";
    }

    @PostMapping("/item_insert")
    public String postDoInsert(@ModelAttribute ItemInfoVo itemInfoVo) {
        itemInfoServiceV3.doInsert(itemInfoVo);
        return "redirect:/v3/item";
    }

    // 삭제하기
    @GetMapping("/item_delete")
    public String getDoDelete(@RequestParam("no") String no) {
        itemInfoServiceV3.doDelete(no);
        return "redirect:/v3/item";
    }

    // 수정하기
    @GetMapping("/item_update")
    public String getDoUpdate(@RequestParam("no") String no, Model model) {
        Map<String, Object> map = itemInfoServiceV3.doListOne(no);
        model.addAttribute("map", map);
        return "/v3/item/item_update";
    }

    @PostMapping("/item_update")
    public String postDoUpdate(@ModelAttribute ItemInfoVo itemInfoVo) {
        itemInfoServiceV3.doUpdate(itemInfoVo);
        return "redirect:/v3/item";
    }

    // 조회하기
    @PostMapping("/item_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "item", defaultValue = "ALL") String item, @RequestParam("kind") String kind, Model model) {
        List<ItemInfoVo> list = itemInfoServiceV3.doSearch(startDate, endDate, item, kind);
        model.addAttribute("list", list);
        log.info(list);
        return "/v3/item/item";
    }

    // 다중 가격 수정
    @PostMapping("/updatePrice")
    public String postDoUpdatePrice(@RequestParam("chkItemNo") List<String> chkList, @RequestParam("hidden_price") String price) {
        if (chkList != null) {
            itemInfoServiceV3.doUpdatePrice(chkList, price);
            itemInfoServiceV3.doUpdateInsert(chkList,price);
        }
        return "redirect:/v3/item";
    }
}