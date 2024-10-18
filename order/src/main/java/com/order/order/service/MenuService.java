package com.order.order.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록(의존성 주입)
@Log4j2
public class MenuService {

    public List<Map<String, Object>> doList() {

        // Data 만들기, List, Map
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "아이스 아메리카노");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2024.10.18");
        map.put("mod_day", "2024.10.18");
        list.add(map);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("No", "2");
        map2.put("name", "카푸치노");
        map2.put("kind", "커피");
        map2.put("price", "6,000");
        map2.put("reg_day", "2024.10.18");
        map2.put("mod_day", "2024.10.18");
        list.add(map2);


        Map<String, Object> map3 = new HashMap<>();
        map3.put("No", "3");
        map3.put("name", "카페라떼");
        map3.put("kind", "커피");
        map3.put("price", "6,500");
        map3.put("reg_day", "2024.10.18");
        map3.put("mod_day", "2024.10.18");
        list.add(map3);

        log.info(list);

        return list;
    }
}
