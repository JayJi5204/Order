package com.order.order.v2.dao;

import com.order.order.v2.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDaoV2 {
    List<MemberVo> doListAll();

    List<MemberVo> doSearch(String startDate, String endDate, String name);
}
