package com.o2o.service.impl;


import com.o2o.dao.ShopDao;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopEnumState;
import com.o2o.exceptions.ShopOperaionException;
import com.o2o.service.ShopService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Override
	public List<Shop> getShopList() {
		return shopDao.queryShop();
	}


	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
		//空值判断
		if (shop == null){
			return new ShopExecution(ShopEnumState.NULL_SHOP_INFO);
		}
		try{
			//给店铺信息赋初值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum < 0){
				throw new ShopOperaionException("店铺创建失败");
				//终止，事务rollback
			}else{
				if(shopImgInputStream !=null) {
					//存储图片
					try {
						addShopImg(shop,shopImgInputStream, fileName);
					}catch (Exception e){
						throw new ShopOperaionException("addShopImg:error" + e.getMessage());
					}
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum < 0){
						throw new ShopOperaionException("更新图片地址失败");
					}
				}
			}

		}catch (Exception e){
			throw new ShopOperaionException("addShop:error" + e.getMessage());
		}
		return new ShopExecution(ShopEnumState.CHECK, shop);
	}

	private void addShopImg(Shop shop, InputStream shopImgInputstream, String fileName) {
		//获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputstream, fileName, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperaionException {
		//是否需要修改图片信息
		try {
			if (shop == null || shop.getShopId() == null) {
				return new ShopExecution(ShopEnumState.NULL_SHOPID);
			} else {
				if (shopImgInputStream != null && fileName != null && !"".equals(fileName)) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					addShopImg(shop, shopImgInputStream, fileName);
				}
				//更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopEnumState.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopEnumState.SUCCESS);
				}
			}
		}catch (Exception e){
			throw new ShopOperaionException("modifyShop error:" + e.getMessage());
		}
	}
}
