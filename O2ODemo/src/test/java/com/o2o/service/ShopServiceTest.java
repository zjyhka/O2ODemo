package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopEnumState;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
	@Autowired
	ShopService shopService;

	@Test
	public void testModifyShop() throws FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(3L);
		shop.setShopName("修改3");
		File shopImg = new File("d:/idea_workspace/dabai.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution se = shopService.modifyShop(shop, is, shopImg.getName());
		System.out.println("new---" + se.getStateInfo());

	}
	@Test
	@Ignore
	public void testAddShop() throws IOException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();

		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺2");
		shop.setShopDesc("test2");
		shop.setShopAddr("test2");
		shop.setPhone("test2");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopEnumState.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("d:/idea_workspace/xiaohuangren.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution shopExecution = shopService.addShop(shop,is,shopImg.getName());
		assertEquals(ShopEnumState.CHECK.getState(), shopExecution.getState());
	}
}
