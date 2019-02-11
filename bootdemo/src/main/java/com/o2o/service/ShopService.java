package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.exceptions.ShopOperaionException;

import java.io.InputStream;


public interface ShopService {

	//通过shopId获取店铺信息
	Shop getByShopId(long shopId);

	//更新店铺信息
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperaionException;

	//添加店铺信息
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperaionException;
}
