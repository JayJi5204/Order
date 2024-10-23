package com.order.order.v2.dao;

import com.order.order.v2.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDaoV2 {
    List<MenuVo> doListAll();

    void doInsert(MenuVo menuVo);

    void doDelete(String no);

    Map<String, Object> doListOne(String no);

    void doUpdate(MenuVo menuVo);

    List<MenuVo> doSearch(String startDate, String endDate, String coffee, String kind);

    void doUpdatePrice(List<String> chkList, String price);
}
