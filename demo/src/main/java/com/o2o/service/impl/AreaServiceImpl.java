package com.o2o.service.impl;

import com.o2o.dao.AreaDao;
import com.o2o.dto.AreaExecution;
import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 注入实现类
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

	@Override
	public AreaExecution addArea(Area area) {
		return null;
	}

	@Override
	public AreaExecution modifyArea(Area area) {
		return null;
	}

	@Override
	public AreaExecution removeArea(long areaId) {
		return null;
	}

	@Override
	public AreaExecution removeAreaList(List<Long> areaIdList) {
		return null;
	}
}
