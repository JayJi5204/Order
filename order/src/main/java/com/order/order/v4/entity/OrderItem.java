package com.order.order.v4.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    private String item;
    private int price;
    private int count;

    @CreatedDate
    private LocalDate regDay;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
