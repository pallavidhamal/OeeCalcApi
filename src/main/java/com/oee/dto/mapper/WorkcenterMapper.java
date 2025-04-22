package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.WorkcenterDto;
import com.oee.entity.WorkcentreEntity;

public class WorkcenterMapper {

	public static WorkcenterDto toWorkcenterDto(WorkcentreEntity WorkcenterEntity) {
		return new WorkcenterDto()
				.setName(WorkcenterEntity.getName());
				
	}
	
	public static List<WorkcenterDto> toWorkcenterDtoList(List<WorkcentreEntity> WorkcenterEntityList) {
		List<WorkcenterDto> WorkcenterDtos = new ArrayList<WorkcenterDto>();
		
		for(WorkcentreEntity WorkcenterEntity : WorkcenterEntityList) {
			WorkcenterDtos.add(toWorkcenterDto(WorkcenterEntity));
		}
		
		return WorkcenterDtos;
	}
	
}
