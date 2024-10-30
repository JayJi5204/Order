package com.order.order.v4.repository;

import com.order.order.v4.entity.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemInfoRepository extends JpaRepository<Item,Long> {
    @Query("SELECT i FROM ItemInfo i WHERE i.regDay BETWEEN :startDate AND :endDate " +
            "AND (:item = 'ALL' OR i.item LIKE %:item%) " +
            "AND (:kind = 'ALL' OR i.kind = :kind)")
    List<Item> findItems(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("item") String item,
            @Param("kind") String kind
    );

    List<Item> findByRegDayBetween(LocalDate startDate, LocalDate endDate);
    List<Item> findByRegDayBetweenAndItemContaining(LocalDate startDate, LocalDate endDate, String item);
    List<Item> findByRegDayBetweenAndKind(LocalDate startDate, LocalDate endDate, String kind);
    List<Item> findByRegDayBetweenAndItemContainingAndKind(LocalDate startDate, LocalDate endDate, String item, String kind);
}
