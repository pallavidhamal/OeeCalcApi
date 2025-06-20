package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.PlanningDto;
import com.oee.entity.PlanningEntity;

public class PlanningMapper {

	public static PlanningDto toPlanningDto(PlanningEntity planningEntity) {
		return new PlanningDto()
				.setId(planningEntity.getId())
				.setUnitid(planningEntity.getUnitentity().getId())
				.setUnitname(planningEntity.getUnitentity().getName())
				.setWorkcenterid(planningEntity.getWorkcenterentity().getId())
				.setWorkcentername(planningEntity.getWorkcenterentity().getName())
				.setFromdate(planningEntity.getFromdate())
				.setTodate(planningEntity.getTodate())
				.setShiftid(planningEntity.getShift().getId())
				.setShiftname(planningEntity.getShift().getName())
				.setTimePerShift(planningEntity.getTimepershift())
				.setIsdeleted(planningEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive")
				.setPlanningShiftWork(PlanningShiftWorkMapper.toPlanningDtoList(planningEntity.getPlanningSiftWorkEntities()));
				
		
	}
	
	public static List<PlanningDto> toPlanningDtoList(List<PlanningEntity> PlanningEntityList) {
		List<PlanningDto> PlanningDtos = new ArrayList<PlanningDto>();
		
		for(PlanningEntity PlanningEntity : PlanningEntityList) {
			PlanningDtos.add(toPlanningDto(PlanningEntity));
		}
		
		return PlanningDtos;
	}
	
	
	public static PlanningDto toOnlyPlanningDto(PlanningEntity planningEntity) {
		return new PlanningDto()
				.setId(planningEntity.getId())
				.setFromdate(planningEntity.getFromdate())
				.setTodate(planningEntity.getTodate())
				.setTimePerShift(planningEntity.getTimepershift())
				
				.setUnitid(planningEntity.getUnitentity().getId())
				.setUnitname(planningEntity.getUnitentity().getName())
				.setWorkcenterid(planningEntity.getWorkcenterentity().getId())
				.setWorkcentername(planningEntity.getWorkcenterentity().getName())
				
				.setIsdeleted(planningEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
				//.setPlanningShiftWork(PlanningShiftWorkMapper.toPlanningDtoList(planningEntity.getPlanningSiftWorkEntities()));
				
		
	}
	
	public static List<PlanningDto> toOnlyPlanningDtoList(List<PlanningEntity> PlanningEntityList) {
		List<PlanningDto> PlanningDtos = new ArrayList<PlanningDto>();
		
		for(PlanningEntity PlanningEntity : PlanningEntityList) {
			PlanningDtos.add(toOnlyPlanningDto(PlanningEntity));
		}
		
		return PlanningDtos;
	}
	
}