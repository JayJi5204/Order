package com.order.order.v4.repository;

import com.order.order.v4.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderItem,Long> {


}
