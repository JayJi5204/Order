package com.order.order.v4.service;

import com.order.order.v4.entity.Item;
import com.order.order.v4.repository.ItemInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemInfoService {

    @Autowired
    ItemInfoRepository itemInfoRepository;


    // 전체 상품 조회
    public List<Item> getAllItems() {
        return itemInfoRepository.findAll();
    }

    // 개별 상품 조회
    public Optional<Item> getItemById(Long no) {
        return itemInfoRepository.findById(no);
    }

    // 상품 등록
    public void createItem(Item item) {
        itemInfoRepository.save(item);
    }

    // 상품 수정
    public void updateItem(Long no, Item item) {
        Item itemInfo = itemInfoRepository.findById(no).orElseThrow();
        itemInfo.update(item);
        itemInfoRepository.save(itemInfo); // 수정된 부분
    }

    // 상품 삭제
    public void deleteItem(Long no) {
        itemInfoRepository.deleteById(no);
    }

    public List<Item> searchItems(String startDate, String endDate, String item, String kind) {
        // String 날짜를 LocalDate로 변환
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);

        // 'ALL'인 경우 모든 항목 포함, 특정 조건만 검색
        if ("ALL".equals(item) && "ALL".equals(kind)) {
            return itemInfoRepository.findByRegDayBetween(startLocalDate, endLocalDate);
        } else if (!"ALL".equals(item) && "ALL".equals(kind)) {
            return itemInfoRepository.findByRegDayBetweenAndItemContaining(startLocalDate, endLocalDate, item);
        } else if ("ALL".equals(item) && !"ALL".equals(kind)) {
            return itemInfoRepository.findByRegDayBetweenAndKind(startLocalDate, endLocalDate, kind);
        } else {
            return itemInfoRepository.findByRegDayBetweenAndItemContainingAndKind(startLocalDate, endLocalDate, item, kind);
        }
    }

//    @Transactional // 이 메서드는 트랜잭션 안에서 실행되어야 합니다
//    public void updatePrice(List<Integer> chkList, String price) {
//        if (chkList != null && !chkList.isEmpty()) {
//            itemInfoRepository.updatePricesByIds(chkList, price);
//        }
//    }
}
