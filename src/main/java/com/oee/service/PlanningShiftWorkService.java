package com.oee.service;

import java.util.List;

import com.oee.dto.incoming.PlanningShiftWorkIncomingDto;
import com.oee.entity.PlanningShiftWorkEntity;


public interface PlanningShiftWorkService {
	
	List<PlanningShiftWorkEntity> getPlanningShiftWorkEntities(List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDtos);
	boolean deletePlanningShiftWork(String id);
	List<PlanningShiftWorkEntity> updateAndDeletePlanningShiftWorkEntities(
			List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDto,
			List<PlanningShiftWorkIncomingDto> planningShiftWorkDeleteIncomingDto);

}
