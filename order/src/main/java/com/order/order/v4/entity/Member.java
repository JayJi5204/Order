package com.order.order.v4.entity;

import com.order.order.v4.comm.Address;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String memberId;
    private String password;
    private String name;
    private String email;

    @Embedded
    private Address address;
    private String role;

    @CreatedDate
    private LocalDate regDay;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Item> item = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<OrderItem> OrderItem = new ArrayList<>();


}
