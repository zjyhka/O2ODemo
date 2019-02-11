package com.o2o.controller;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "Area", description = "地区管理")
@RequestMapping("/area")
@Validated
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	private AreaService areaService;

	@GetMapping(value = "arealist")
	@ApiOperation(value = "获取地区列表", notes = "返回地区列表")
	public List<Area> getAreaList(){
		return areaService.getAreaList();
	}

}
