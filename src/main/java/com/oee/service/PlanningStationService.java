package com.oee.service;

import java.util.List;

import com.oee.dto.incoming.PlanningShiftWorkIncomingDto;
import com.oee.dto.incoming.PlanningStationIncomingDto;
import com.oee.entity.PlanningShiftWorkEntity;
import com.oee.entity.PlanningStationsEntity;


public interface PlanningStationService {
	
	List<PlanningStationsEntity> getPlanningStationEntities(List<PlanningStationIncomingDto> planningStationIncomingDto);

}
