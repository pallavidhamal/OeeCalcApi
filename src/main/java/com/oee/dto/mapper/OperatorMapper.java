package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.OperatorDto;
import com.oee.entity.OperatorEntity;

public class OperatorMapper {

	public static OperatorDto toOperatorDto(OperatorEntity OperatorEntity) {
		return new OperatorDto()
				.setId(OperatorEntity.getId())
				.setName(OperatorEntity.getName());
				
	}
	
	public static List<OperatorDto> toOperatorDtoList(List<OperatorEntity> OperatorEntityList) {
		List<OperatorDto> OperatorDtos = new ArrayList<OperatorDto>();
		
		for(OperatorEntity OperatorEntity : OperatorEntityList) {
			OperatorDtos.add(toOperatorDto(OperatorEntity));
		}
		
		return OperatorDtos;
	}
	
}
