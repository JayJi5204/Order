package com.order.order.v3.service;

import com.order.order.v3.dao.LoginDaoV3;
import com.order.order.v3.vo.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceV3 {

    @Autowired
    LoginDaoV3 loginDaoV3;
    public MemberInfoVo doLogin(String id) {
       return loginDaoV3.doLogin(id);
    }
}
