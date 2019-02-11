package com.o2o.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@ApiModel(value="Area", description = "地区")
public class Area {
	//ID
	@ApiModelProperty(value = "areaId")
	private Integer areaId;
	// 名称
	@ApiModelProperty(value = "areaName")
	@NotBlank(message = "地区名称不能为空")
	private String areaName;
	//权重
	@ApiModelProperty(value = "priority")
	private Integer priority;
	// 创建时间
	@ApiModelProperty(value = "createTime")
	private Date createTime;
	// 更新时间
	@ApiModelProperty(value = "astEditTime")
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
}
