package com.o2o.service;

import com.o2o.dto.AreaExecution;
import com.o2o.entity.Area;

import java.util.List;

public interface AreaService {
	List<Area> getAreaList();

	AreaExecution addArea(Area area);

	AreaExecution modifyArea(Area area);


	AreaExecution removeArea(long areaId);


	AreaExecution removeAreaList(List<Long> areaIdList);

}
