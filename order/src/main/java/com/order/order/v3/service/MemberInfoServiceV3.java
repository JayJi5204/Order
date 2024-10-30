package com.order.order.v3.service;

import com.order.order.v3.dao.MemberInfoDaoV3;
import com.order.order.v3.vo.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberInfoServiceV3 {
    @Autowired
    MemberInfoDaoV3 memberInfoDaoV3;
    public List<MemberInfoVo> doListAll() {
       return memberInfoDaoV3.doListAll();
    }

    public List<MemberInfoVo> doSearch(String startDate, String endDate, String name) {
        return memberInfoDaoV3.doSearch(startDate,endDate,name);
    }
}
