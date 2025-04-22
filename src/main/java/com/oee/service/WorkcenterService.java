package com.oee.service;

import java.util.List;

import com.oee.dto.WorkcenterDto;
import com.oee.entity.WorkcentreEntity;  


public interface WorkcenterService {

	List<WorkcenterDto> getAllWorkcenters();
	
	WorkcentreEntity getWorkcenterByID(String workcenterID);
	
	
}
