package com.order.order;

import com.order.order.v4.entity.Member;
import com.order.order.v4.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class OrderItemApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void doMember_Info() {
        List<Member> list = memberRepository.findAll();

        String pass;
        for (Member member : list) {
            // passwd 암호화 설정
            pass = member.getPassword();
            pass = passwordEncoder.encode((pass));
            member.setPassword(pass);
        }

        // 개인정보 저장
        System.out.println(list);
    }

    @Test
    void doMember_InfoId() {
        Member id3 = memberRepository.findMemberInfoByMemberId("ID3");
        System.out.println(id3);
    }

}
