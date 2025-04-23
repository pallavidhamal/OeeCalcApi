package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.StationTypeDto;
import com.oee.entity.StationTypeEntity;

public class StationTypeMapper {

	public static StationTypeDto toStationTypeDto(StationTypeEntity stationTypeEntity) {
		return new StationTypeDto()
				.setId(stationTypeEntity.getId())
				.setName(stationTypeEntity.getName());
				
	}
	
	public static List<StationTypeDto> toStationTypeDtoList(List<StationTypeEntity> StationTypeEntityList) {
		List<StationTypeDto> StationTypeDtos = new ArrayList<StationTypeDto>();
		
		for(StationTypeEntity StationTypeEntity : StationTypeEntityList) {
			StationTypeDtos.add(toStationTypeDto(StationTypeEntity));
		}
		
		return StationTypeDtos;
	}
	
}
