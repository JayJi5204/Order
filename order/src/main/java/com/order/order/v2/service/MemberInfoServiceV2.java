package com.order.order.v2.service;

import com.order.order.v2.dao.MemberInfoDaoV2;
import com.order.order.v2.vo.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberInfoServiceV2 {
    @Autowired
    MemberInfoDaoV2 memberInfoDaoV2;
    public List<MemberInfoVo> doListAll() {
       return memberInfoDaoV2.doListAll();
    }

    public List<MemberInfoVo> doSearch(String startDate, String endDate, String name) {
        return memberInfoDaoV2.doSearch(startDate,endDate,name);
    }
}
