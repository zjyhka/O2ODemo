package com.o2o.service;


import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopEnumState;
import com.o2o.exceptions.ShopOperaionException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Date;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest{
	@Autowired
	ShopService shopService;

	@Test
	public void testModifyShop() throws FileNotFoundException, ShopOperaionException {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改之后的");
		File shopImg = new File("D:/idea_workspace/dabai.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution shopExecution =
				shopService.modifyShop(shop, is, "dabai.jpg");
		System.out.println(shopExecution.getStateInfo());
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
		shop.setShopName("测试的店铺4");
		shop.setShopDesc("test4");
		shop.setShopAddr("test2");
		shop.setPhone("test2");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopEnumState.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("D:/idea_workspace/xiaohuangren.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution shopExecution = shopService.addShop(shop, is, shopImg.getName());
		assertEquals(ShopEnumState.CHECK.getState(), shopExecution.getState());
	}
}
