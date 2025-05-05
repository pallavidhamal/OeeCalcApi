package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.WorkcenterDto;
import com.oee.entity.WorkcenterEntity;

public class WorkcenterMapper {

	public static WorkcenterDto toWorkcenterDto(WorkcenterEntity WorkcenterEntity) {
		return new WorkcenterDto()
				.setId(WorkcenterEntity.getId())
				.setName(WorkcenterEntity.getName());
				
	}
	
	public static List<WorkcenterDto> toWorkcenterDtoList(List<WorkcenterEntity> WorkcenterEntityList) {
		List<WorkcenterDto> WorkcenterDtos = new ArrayList<WorkcenterDto>();
		
		for(WorkcenterEntity WorkcenterEntity : WorkcenterEntityList) {
			WorkcenterDtos.add(toWorkcenterDto(WorkcenterEntity));
		}
		
		return WorkcenterDtos;
	}
	
}
