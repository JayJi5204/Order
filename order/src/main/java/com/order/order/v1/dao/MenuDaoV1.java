package com.order.order.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDaoV1 {
    List<Map<String, Object>> doListAll();

    void doInsert(String coffee, String kind, String price);

    void doDelete(String no);

    Map<String, Object> doListOne(String no);

    void doUpdate(String no, String coffee, String kind, String price);

    List<Map<String, Object>> doSearch(String startDate, String endDate, String coffee, String kind);

    void doUpdatePrice(List<String> chkList, String price);
}
