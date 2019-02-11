package com.o2o.dao;

import com.o2o.entity.ShopCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory(){
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(2, shopCategoryList.size());
		ShopCategory testsc = new ShopCategory();
		ShopCategory testscp = new ShopCategory();
		testscp.setShopCategoryId(1L);
		testsc.setParent(testscp);
		shopCategoryList = shopCategoryDao.queryShopCategory(testsc);
		assertEquals(1, shopCategoryList.size());
		System.out.println(shopCategoryList.get(0).getShopCategoryName());
	}
}

