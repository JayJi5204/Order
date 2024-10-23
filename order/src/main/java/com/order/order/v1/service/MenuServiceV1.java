package com.order.order.v1.service;

import com.order.order.v1.dao.MenuDaoV1;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class MenuServiceV1 {

    @Autowired
    MenuDaoV1 menuDaoV1;

    // 커피 메뉴의 모든 데이터를 가져옴
    public List<Map<String, Object>> doListAll() {
        return menuDaoV1.doListAll();
    }

    // 커피 메뉴 데이터를 추가함
    public void doInsert(String coffee, String kind, String price) {
        menuDaoV1.doInsert(coffee, kind, price);
    }

    // 커피 메뉴 데이터를 삭제함
    public void doDelete(String no) {
        menuDaoV1.doDelete(no);
    }

    // 커피 메뉴의 하나의 데이터를 가져옴
    public Map<String, Object> doListOne(String no) {
        return menuDaoV1.doListOne(no);
    }

    public void doUpdate(String no, String coffee, String kind, String price) {
        menuDaoV1.doUpdate(no, coffee, kind, price);
    }

    public List<Map<String, Object>> doSearch(String startDate, String endDate, String coffee, String kind) {
        return menuDaoV1.doSearch(startDate, endDate, coffee, kind);
    }

    public void doUpdatePrice(List<String> chkList, String price) {
        menuDaoV1.doUpdatePrice(chkList, price);
    }
}
