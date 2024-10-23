package com.order.order.v2.service;

import com.order.order.v2.dao.MemberDaoV2;
import com.order.order.v2.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceV2 {
    @Autowired
    MemberDaoV2 memberDaoV2;
    public List<MemberVo> doListAll() {
       return memberDaoV2.doListAll();
    }

    public List<MemberVo> doSearch(String startDate, String endDate, String name) {
        return memberDaoV2.doSearch(startDate,endDate,name);
    }
}
