package com.order.order.v1.service;

import com.order.order.v1.dao.ItemInfoDaoV1;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class ItemInfoServiceV1 {

    @Autowired
    ItemInfoDaoV1 itemInfoDaoV1;

    // 커피 메뉴의 모든 데이터를 가져옴
    public List<Map<String, Object>> doListAll() {
        return itemInfoDaoV1.doListAll();
    }

    // 커피 메뉴 데이터를 추가함
    public void doInsert(String item, String kind, String price) {
        itemInfoDaoV1.doInsert(item, kind, price);
    }

    // 커피 메뉴 데이터를 삭제함
    public void doDelete(String no) {
        itemInfoDaoV1.doDelete(no);
    }

    // 커피 메뉴의 하나의 데이터를 가져옴
    public Map<String, Object> doListOne(String no) {
        return itemInfoDaoV1.doListOne(no);
    }

    public void doUpdate(String no, String item, String kind, String price) {
        itemInfoDaoV1.doUpdate(no, item, kind, price);
    }

    public List<Map<String, Object>> doSearch(String startDate, String endDate, String item, String kind) {
        return itemInfoDaoV1.doSearch(startDate, endDate, item, kind);
    }

    public void doUpdatePrice(List<String> chkList, String price) {
        itemInfoDaoV1.doUpdatePrice(chkList, price);
    }
}
