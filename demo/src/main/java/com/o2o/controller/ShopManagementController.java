package com.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopEnumState;
import com.o2o.exceptions.ShopOperaionException;
import com.o2o.service.AreaService;
import com.o2o.service.ShopCategoryService;
import com.o2o.service.ShopService;
import com.o2o.util.CodeUtil;
import com.o2o.util.HttpServletRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/shop")
@Api(value = "商铺操作")
public class ShopManagementController {
	@Autowired
	ShopService shopService;
	@Autowired
	ShopCategoryService shopCategoryService;
	@Autowired
	AreaService areaService;

	@GetMapping(value = "/{shopId}")
	@ApiOperation(value = "获取商铺详情", notes = "根据用户id获取用户信息")
	@ApiImplicitParam(name = "id", value = "商户id", required = true, paramType = "query", dataType = "Integer")

	public Shop getShopById(@PathVariable("shopId") int shopId) {

		Shop shop = shopService.getByShopId(shopId);
		return shop;
	}

	@ApiOperation(value = "获取商户列表", notes = "获取商户列表")
	@GetMapping(value = "/shoplist")
	public List<Shop> getShopList() {
		return shopService.getShopList();
	}
}

