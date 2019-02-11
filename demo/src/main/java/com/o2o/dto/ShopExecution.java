package com.o2o.dto;


import com.o2o.entity.Shop;
import com.o2o.enums.ShopEnumState;

import java.util.List;

public class ShopExecution {
	//结果状态
	private int state;
	//状态标识
	private String stateInfo;
	//店铺数量
	private int count;
	//操作的店铺
	private Shop shop;
	//店铺列表（查询店铺列表）
	private List<Shop> shopList;

	public ShopExecution(){
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

	//失败的构造器
	public ShopExecution(ShopEnumState stateEnum){
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	//店铺创建成功的构造器
	public ShopExecution(ShopEnumState stateEnum, Shop shop){
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	//店铺列表创建成功的构造器，返回列表
	public ShopExecution(ShopEnumState stateEnum, List<Shop> shopList){
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}

}
