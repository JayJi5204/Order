package com.order.order.v4.service;

import com.order.order.v4.entity.Member;
import com.order.order.v4.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Member> searchMember(String startDate, String endDate, String name) {
        // String 날짜를 LocalDate로 변환
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);

        // 'ALL'인 경우 모든 항목 포함, 특정 조건만 검색
        if ("ALL".equals(name)) {
            return memberRepository.findByRegDayBetween(startLocalDate, endLocalDate);
        }
            return memberRepository.findByRegDayBetweenAndNameContaining(startLocalDate, endLocalDate,name);

    }
}
