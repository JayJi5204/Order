package com.order.order;

import com.order.order.v1.dao.MenuDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class OrderApplicationTests {

	@Autowired
	MenuDao menuDao;

	@Test
	void doList() {
		List<Map<String, Object>> list = menuDao.doListAll();
		System.out.println(list);
	}

	@Test
	void doInsert() {
		menuDao.doInsert("테스트","테스트","0");
	}

}
