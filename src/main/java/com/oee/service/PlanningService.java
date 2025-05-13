package com.oee.service;

import java.util.List;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;


public interface PlanningService {

	List<PlanningDto> getAllPlannings();
	
	PlanningDto getPlanningByID(String planningID);
	
	boolean addPlanning( PlanningIncomingDto planningIncomingDto);
	//boolean editPlanning( PlanningIncomingDto planningIncomingDto);
	boolean deletePlanning(String planningID);
	
	
	//List<PlanningDto> getPlanningsByItemMachine( PlanningIncomingDto planningIncomingDto) ;
}
