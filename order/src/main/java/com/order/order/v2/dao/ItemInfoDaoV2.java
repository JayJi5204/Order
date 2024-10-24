package com.order.order.v2.dao;

import com.order.order.v2.vo.ItemInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemInfoDaoV2 {
    List<ItemInfoVo> doListAll();

    void doInsert(ItemInfoVo itemInfoVo);

    void doDelete(String no);

    Map<String, Object> doListOne(String no);

    void doUpdate(ItemInfoVo itemInfoVo);

    List<ItemInfoVo> doSearch(String startDate, String endDate, String item, String kind);

    void doUpdatePrice(List<String> chkList, String price);
}
