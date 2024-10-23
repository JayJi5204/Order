package com.order.order.v2.service;

import com.order.order.v2.dao.OrderDaoV2;
import com.order.order.v2.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceV2 {
    @Autowired
    OrderDaoV2 orderDaoV2;

    public List<OrderVo> doListAll() {
        return orderDaoV2.doListAll();
    }

    public List<OrderVo> doSearch(String startDate, String endDate, String coffee, String name) {
        return orderDaoV2.doSearch(startDate, endDate, coffee, name);
    }
}
