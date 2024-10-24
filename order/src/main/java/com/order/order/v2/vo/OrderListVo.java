package com.order.order.v2.vo;

import lombok.Data;

@Data
public class OrderListVo {
    private String no;
    private String item_no;
    private String item;
    private String price;
    private String member_id;
    private String name;
    private String reg_day;
}
