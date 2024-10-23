package com.order.order.v2.dao;

import com.order.order.v2.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDaoV2 {
    List<OrderVo> doListAll();

    List<OrderVo> doSearch(String startDate, String endDate, String coffee, String name);
}
