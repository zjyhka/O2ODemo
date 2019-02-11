package com.o2o.Dao;

import com.o2o.BaseTest;
import com.o2o.dao.AreaDao;
import com.o2o.dao.ShopCategoryDao;
import com.o2o.entity.Area;
import com.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryTest extends BaseTest{

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

