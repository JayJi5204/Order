package com.order.order.v1.service;

import com.order.order.v1.dao.MenuDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class MenuService {

    @Autowired
    MenuDao menuDao;

    // 커피 메뉴의 모든 데이터를 가져옴
    public List<Map<String, Object>> doListAll() {
        return menuDao.doListAll();
    }

    // 커피 메뉴 데이터를 추가함
    public void doInsert(String coffee, String kind, String price) {
        menuDao.doInsert(coffee,kind,price);
    }

    // 커피 메뉴 데이터를 삭제함
    public void doDelete(String no) {
        menuDao.doDelete(no);
    }

    // 커피 메뉴의 하나의 데이터를 가져옴
    public Map<String, Object> doListOne(String no) {
        return menuDao.doListOne(no);
    }

    public void doUpdate(String no, String coffee, String kind, String price) {
        menuDao.doUpdate(no,coffee,kind,price);
    }

    public List<Map<String, Object>> doSearch(String startDate, String endDate, String coffee, String kind) {
        return menuDao.doSearch(startDate,endDate,coffee,kind);
    }
}
