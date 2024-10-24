package com.order.order.v2.dao;

import com.order.order.v2.vo.MemberInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberInfoDaoV2 {
    List<MemberInfoVo> doListAll();

    List<MemberInfoVo> doSearch(String startDate, String endDate, String name);
}
