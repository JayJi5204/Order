package com.order.order.v2.dao;

import com.order.order.v2.vo.OrderListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderListDaoV2 {
    List<OrderListVo> doListAll();

    List<OrderListVo> doSearch(String startDate, String endDate, String item, String name);
}
