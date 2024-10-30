package com.order.order.v3.service;

import com.order.order.v3.dao.OrderListDaoV3;
import com.order.order.v3.vo.OrderListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceV3 {
    @Autowired
    OrderListDaoV3 orderListDaoV3;

    public List<OrderListVo> doListAll() {
        return orderListDaoV3.doListAll();
    }

    public List<OrderListVo> doSearch(String startDate, String endDate, String item, String name) {
        return orderListDaoV3.doSearch(startDate, endDate, item, name);
    }
}
