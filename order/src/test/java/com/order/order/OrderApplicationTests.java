package com.order.order;

import com.order.order.v1.dao.MenuDaoV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class OrderApplicationTests {

	@Autowired
	MenuDaoV1 menuDaoV1;

	@Test
	void doList() {
		List<Map<String, Object>> list = menuDaoV1.doListAll();
		System.out.println(list);
	}

	@Test
	void doInsert() {
		menuDaoV1.doInsert("테스트","테스트","0");
	}

}
