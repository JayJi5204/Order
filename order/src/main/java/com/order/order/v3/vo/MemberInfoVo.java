package com.order.order.v3.vo;

import lombok.Data;

@Data
public class MemberInfoVo {
    private String no;
    private String member_id;
    private String name;
    private String email;
    private String role;
    private String reg_day;
    private String passwd;
}
