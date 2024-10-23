package com.order.order.v2.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MenuVo {
    private String no;
    private String coffee;
    private String kind;
    private String price;
    private String reg_day;
    private String mod_day;
}
