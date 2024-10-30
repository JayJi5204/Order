package com.order.order.v3.dao;

import com.order.order.v3.vo.MemberInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDaoV3 {
    MemberInfoVo doLogin(String id);
}
