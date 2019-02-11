package com.o2o.enums;

public enum ShopEnumState {
	CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"),
	INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPID(-1002, "ShopId为空"),
	NULL_SHOP_INFO(-1003, "传入了空的信息");

	private int state;
	private String stateInfo;

	private ShopEnumState(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ShopEnumState stateOf(int index) {
		for (ShopEnumState stateEnum : values()) {
			if (stateEnum.getState() == index) {
				return stateEnum;
			}
		}
		return null;
	}
}
