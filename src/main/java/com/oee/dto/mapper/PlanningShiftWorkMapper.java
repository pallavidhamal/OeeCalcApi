package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.PlanningDto;
import com.oee.dto.PlanningShiftWorkDto;
import com.oee.entity.PlanningEntity;
import com.oee.entity.PlanningShiftWorkEntity;

public class PlanningShiftWorkMapper {

	public static PlanningShiftWorkDto toPlanningShiftworkDto(PlanningShiftWorkEntity planningshiftEntity) {
		return new PlanningShiftWorkDto()
				.setId(planningshiftEntity.getId())
				.setStationid(planningshiftEntity.getStation().getId())
				.setStationname(planningshiftEntity.getStation().getName())
				.setItemid(planningshiftEntity.getItem().getId())
				.setItemname(planningshiftEntity.getItem().getItemdesc())
				.setSetupid(planningshiftEntity.getSetup().getId())
				.setSetupname(planningshiftEntity.getSetup().getName())
				.setSetuptime(planningshiftEntity.getSetuptime())
				.setCycletime(planningshiftEntity.getCycletime())
				.setPlannedquantity(planningshiftEntity.getPlannedquantity())
				.setPlannedmins(planningshiftEntity.getPlannedmins())
				.setIsdeleted(planningshiftEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive")
				.setMachinetimeutilised(planningshiftEntity.getMachinetimeutilised())
				.setItemtimeutilised(planningshiftEntity.getItemtimeutilised());
		
		
		/*
		 * .setStationid(planningshiftEntity.getStation().getId())
		 * .setStationname(planningshiftEntity.getStation().getName())
		 * .setShiftid(planningshiftEntity.getShift().getId())
		 * .setShiftname(planningshiftEntity.getShift().getName())
		 */
		
	}
	
	public static List<PlanningShiftWorkDto> toPlanningDtoList(List<PlanningShiftWorkEntity> planningshiftEntityList) {
		
		List<PlanningShiftWorkDto> planningShiftDtos = new ArrayList<PlanningShiftWorkDto>();
		
		for(PlanningShiftWorkEntity planningShiftWorkEntity : planningshiftEntityList) {
		
			planningShiftDtos.add(toPlanningShiftworkDto(planningShiftWorkEntity));
		}
		
		return planningShiftDtos;
	}
	
	
	/*
	 * .setFromdate(planningEntity.getFromdate())
	 * .setTodate(planningEntity.getTodate())
	 * .setTimePerShift(planningEntity.getTimepershift())
	 * .setPlanningShiftWork((planningEntity.getPlanningSiftWorkEntities())
	 */	
}