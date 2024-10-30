package com.order.order.v3.dao;

import com.order.order.v3.vo.MemberInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberInfoDaoV3 {
    List<MemberInfoVo> doListAll();

    List<MemberInfoVo> doSearch(String startDate, String endDate, String name);
}
