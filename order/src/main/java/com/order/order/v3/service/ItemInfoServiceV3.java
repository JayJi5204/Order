package com.order.order.v3.service;

import com.order.order.v3.dao.ItemInfoDaoV3;
import com.order.order.v3.vo.ItemInfoVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class ItemInfoServiceV3 {

    @Autowired
    ItemInfoDaoV3 itemInfoDaoV3;

    // 커피 메뉴의 모든 데이터를 가져옴
    public List<ItemInfoVo> doListAll() {
        return itemInfoDaoV3.doListAll();
    }

    // 커피 메뉴 데이터를 추가함
    public void doInsert(ItemInfoVo itemInfoVo) {
        itemInfoDaoV3.doInsert(itemInfoVo);
    }

    // 커피 메뉴 데이터를 삭제함
    public void doDelete(String no) {
        itemInfoDaoV3.doDelete(no);
    }

    // 커피 메뉴의 하나의 데이터를 가져옴
    public Map<String, Object> doListOne(String no) {
        return itemInfoDaoV3.doListOne(no);
    }

    public void doUpdate(ItemInfoVo itemInfoVo) {
        itemInfoDaoV3.doUpdate(itemInfoVo);
    }

    public List<ItemInfoVo> doSearch(String startDate, String endDate, String item, String kind) {
        return itemInfoDaoV3.doSearch(startDate, endDate, item, kind);
    }

    public void doUpdatePrice(List<String> chkList, String price) {
        itemInfoDaoV3.doUpdatePrice(chkList, price);
    }

    public void doUpdateInsert(List<String> chkList, String price) {
        itemInfoDaoV3.doUpdatePrice(chkList, price);
    }
}
