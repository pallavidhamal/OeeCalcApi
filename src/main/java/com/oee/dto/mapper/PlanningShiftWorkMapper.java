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
				.setIsdeleted(planningshiftEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
		
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