package com.oee.service;

import java.util.List;
import java.util.Map;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.entity.PlanningEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;


public interface PlanningService {

	List<PlanningDto> getAllPlannings();
	
	List<PlanningDto> getAllPlanningsWDetails();
	
	PlanningDto getPlanningByID(String planningID);
	
	PlanningEntity getPlanningEntityByID(String planningID);
	
	boolean addPlanning( PlanningIncomingDto planningIncomingDto);
	boolean editPlanning( PlanningIncomingDto planningIncomingDto);
	boolean deletePlanning(String planningID);
	
	List<PlanningDto> getFilterPlannings(PlanningIncomingDto planningIncomingDto);
	List<PlanningDto> getFilterPlanningsExist(PlanningIncomingDto planningIncomingDto);
	
	
	PlanningDto getFilterPlanEntity(PlanningIncomingDto planningIncomingDto);
	
	List<Map<String, String>> getFilterPlanEntityWithGroupBy(PlanningIncomingDto planningIncomingDto);

	PlanningDto getPlanningByIDAndStation(String planId, String stationId);
	
	//List<PlanningDto> getPlanningsByItemMachine( PlanningIncomingDto planningIncomingDto) ;
}
