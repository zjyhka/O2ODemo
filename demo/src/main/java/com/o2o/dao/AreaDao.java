package com.o2o.dao;

import com.o2o.entity.Area;

import java.util.List;

public interface AreaDao {
	List<Area> queryArea();

	int insertArea(Area area);


	int updateArea(Area area);


	int deleteArea(long areaId);

}
