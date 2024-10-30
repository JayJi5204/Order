package com.order.order.v4.repository;

import com.order.order.v4.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberInfoByMemberId(String memberId);
    List<Member> findByRegDayBetween(LocalDate startDate, LocalDate endDate);
    List<Member> findByRegDayBetweenAndNameContaining(LocalDate startDate, LocalDate endDate, String name);

}
