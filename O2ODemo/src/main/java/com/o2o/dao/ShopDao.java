package com.o2o.dao;

import com.o2o.entity.Shop;

public interface ShopDao {
	//新增店铺 -1不成功 1成功
	int insertShop(Shop shop);

	// 更新店铺信息
	int updateShop(Shop shop);

	//通过shop id查询
	Shop queryByShopId(long shopId);
}
