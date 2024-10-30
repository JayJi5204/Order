package com.order.order.v3.controller;

import com.order.order.v3.service.MemberInfoServiceV3;
import com.order.order.v3.vo.MemberInfoVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/v3")
@Log4j2
public class MemberInfoControllerV3 {
    @Autowired
    MemberInfoServiceV3 memberInfoServiceV3;

    // 회원 목록 화면
    @RequestMapping("/member")
    public String doMember(Model model) {
        List<MemberInfoVo> list = memberInfoServiceV3.doListAll();
        model.addAttribute("list", list);
        return "/v3/member/member";
    }

    // 조회하기
    @PostMapping("/member_search")
    public String postDoSearch(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate, @RequestParam(value = "name", defaultValue = "ALL") String name, Model model) {
        List<MemberInfoVo> list = memberInfoServiceV3.doSearch(startDate, endDate, name);
        model.addAttribute("list", list);
        log.info(list);
        return "/v3/member/member";
    }
}
