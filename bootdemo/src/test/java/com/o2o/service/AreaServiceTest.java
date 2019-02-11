package com.o2o.service;

import com.o2o.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest{
	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList(){
		List<Area> areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
	}
}
