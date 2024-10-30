package com.order.order.v4.controller;

import com.order.order.v4.entity.Item;
import com.order.order.v4.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v4")
public class ItemInfoController {

    @Autowired
    ItemInfoService itemInfoService;

    // 상품 목록 화면
    @GetMapping("/item")
    public String doItem(Model model) {
        List<Item> list = itemInfoService.getAllItems();
        model.addAttribute("list", list);
        return "/v4/item/item";
    }

    // 등록하기
    @GetMapping("/item_insert")
    public String getDoInsert() {
        return "/v4/item/item_insert";
    }

    @PostMapping("/item_insert")
    public String postDoInsert(@ModelAttribute Item item) {
        itemInfoService.createItem(item);
        return "redirect:/v4/item";
    }

    // 삭제하기
    @GetMapping("/item_delete")
    public String getDoDelete(@RequestParam("no") Long no) {
        itemInfoService.deleteItem(no);
        return "redirect:/v4/item";
    }

    // 수정하기
    @GetMapping("/item_update")
    public String getDoUpdate(@RequestParam("no") Long no, Model model) {
        Item item = itemInfoService.getItemById(no).orElse(null);
        model.addAttribute("itemInfo", item);
        return "/v4/item/item_update";
    }

    @PostMapping("/item_update")
    public String postDoUpdate(@RequestParam Long no,
                               @ModelAttribute Item item) {
        itemInfoService.updateItem(no, item);
        return "redirect:/v4/item";
    }

    //조회하기
    @PostMapping("/item_search")
    public String postDoSearch(@RequestParam("start_date") String startDate,
                               @RequestParam("end_date") String endDate,
                               @RequestParam(value = "item", defaultValue = "ALL") String item,
                               @RequestParam(value = "kind", defaultValue = "ALL") String kind, Model model) {

        List<Item> list = itemInfoService.searchItems(startDate, endDate, item, kind);

        model.addAttribute("list", list);
        return "/v4/item/item";
    }

//    // 다중 가격 수정
//    @PostMapping("/updatePrice")
//    public String postDoUpdatePrice(@RequestParam("chkItemNo") List<Integer> chkList,
//                                    @RequestParam("hidden_price") String price) {
//        if (chkList != null) {
//            itemInfoService.updatePrice(chkList, price);
//        }
//        return "redirect:/v4/item";
//    }
}
