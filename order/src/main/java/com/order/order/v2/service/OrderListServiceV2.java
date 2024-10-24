package com.order.order.v2.service;

import com.order.order.v2.dao.OrderListDaoV2;
import com.order.order.v2.vo.OrderListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceV2 {
    @Autowired
    OrderListDaoV2 orderListDaoV2;

    public List<OrderListVo> doListAll() {
        return orderListDaoV2.doListAll();
    }

    public List<OrderListVo> doSearch(String startDate, String endDate, String item, String name) {
        return orderListDaoV2.doSearch(startDate, endDate, item, name);
    }
}
