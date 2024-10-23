package com.order.order.v2.service;

import com.order.order.v2.dao.MenuDaoV2;
import com.order.order.v2.vo.MenuVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class MenuServiceV2 {

    @Autowired
    MenuDaoV2 menuDaoV2;

    // 커피 메뉴의 모든 데이터를 가져옴
    public List<MenuVo> doListAll() {
        return menuDaoV2.doListAll();
    }

    // 커피 메뉴 데이터를 추가함
    public void doInsert(MenuVo menuVo) {
        menuDaoV2.doInsert(menuVo);
    }

    // 커피 메뉴 데이터를 삭제함
    public void doDelete(String no) {
        menuDaoV2.doDelete(no);
    }

    // 커피 메뉴의 하나의 데이터를 가져옴
    public Map<String, Object> doListOne(String no) {
        return menuDaoV2.doListOne(no);
    }

    public void doUpdate(MenuVo menuVo) {
        menuDaoV2.doUpdate(menuVo);
    }

    public List<MenuVo> doSearch(String startDate, String endDate, String coffee, String kind) {
        return menuDaoV2.doSearch(startDate, endDate, coffee, kind);
    }

    public void doUpdatePrice(List<String> chkList, String price) {
        menuDaoV2.doUpdatePrice(chkList, price);
    }
}
