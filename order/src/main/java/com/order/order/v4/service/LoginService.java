package com.order.order.v4.service;

import com.order.order.v4.entity.Member;
import com.order.order.v4.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

   private final MemberRepository memberRepository;
    public Member doLogin(String id) {
       return memberRepository.findMemberInfoByMemberId(id);
    }
}
