package com.oee.service;

import java.util.List;

import com.oee.dto.WorkcenterDto;
import com.oee.entity.WorkcentreEntity;  


public interface WorkcenterService {

	List<WorkcenterDto> getAllWorkcenters();
	List<WorkcenterDto> getAllActiveWorkcenters();
	
	WorkcentreEntity getWorkcenterByID(String workcenterID);
	
	
}
