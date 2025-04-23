package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.UomDto;
import com.oee.entity.UomEntity;

public class UomMapper {

	public static UomDto toUomDto(UomEntity uomEntity) {
		return new UomDto()
				.setId(uomEntity.getId())
				.setName(uomEntity.getName());
				
	}
	
	public static List<UomDto> toUomDtoList(List<UomEntity> UomEntityList) {
		List<UomDto> UomDtos = new ArrayList<UomDto>();
		
		for(UomEntity UomEntity : UomEntityList) {
			UomDtos.add(toUomDto(UomEntity));
		}
		
		return UomDtos;
	}
	
}
