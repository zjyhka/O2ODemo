package com.o2o.entity;

import java.util.Date;

public class WechatAuth {
	private Long wechatAuthid;
	private Long userId;
	private String openid;
	private Date createTime;
	private PersonInfo personInfo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWechatAuthid() {
		return wechatAuthid;
	}

	public void setWechatAuthid(Long wechatAuthid) {
		this.wechatAuthid = wechatAuthid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
