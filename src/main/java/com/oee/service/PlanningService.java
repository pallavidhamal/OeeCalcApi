package com.oee.service;

import java.util.List;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;


public interface PlanningService {

	List<PlanningDto> getAllPlannings();
	
	List<PlanningDto> getAllPlanningsWDetails();
	
	PlanningDto getPlanningByID(String planningID);
	
	boolean addPlanning( PlanningIncomingDto planningIncomingDto);
	//boolean editPlanning( PlanningIncomingDto planningIncomingDto);
	boolean deletePlanning(String planningID);
	
	List<PlanningDto> getFilterPlannings(PlanningIncomingDto planningIncomingDto);
	
	
	//List<PlanningDto> getPlanningsByItemMachine( PlanningIncomingDto planningIncomingDto) ;
}
