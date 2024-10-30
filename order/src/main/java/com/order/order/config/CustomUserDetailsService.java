//package com.order.order.config;
//
//import com.order.order.v4.entity.MemberInfo;
//import com.order.order.v4.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    MemberRepository memberRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MemberInfo memberInfo = memberRepository.findMemberInfoByMemberId(username);
//        return User.builder().
//                username(memberInfo.getMemberId()).
//                password(memberInfo.getPassword()).
//                roles(memberInfo.getRole()).build();
//    }
//}
