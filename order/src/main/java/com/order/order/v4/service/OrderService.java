package com.order.order.v4.service;

import com.order.order.v4.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderListRepository orderListRepository;
}
