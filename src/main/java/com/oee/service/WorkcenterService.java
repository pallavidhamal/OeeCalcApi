package com.oee.service;

import java.util.List;

import com.oee.dto.WorkcenterDto;
import com.oee.entity.WorkcenterEntity;


public interface WorkcenterService {

	List<WorkcenterDto> getAllWorkcenters();
	List<WorkcenterDto> getAllActiveWorkcenters();
	
	WorkcenterEntity getWorkcenterByID(String workcenterID);
	WorkcenterEntity getActiveWorkcenterByID(String workcenterID);
	
	List<WorkcenterDto> getWorkcenterByUnit(String UnitID); 
}
