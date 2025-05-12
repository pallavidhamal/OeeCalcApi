package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.StationDto;
import com.oee.entity.StationEntity;

public class StationMapper {

	public static StationDto toStationDto(StationEntity stationEntity) {
		return new StationDto()
				.setId(stationEntity.getId())
				.setName(stationEntity.getName())
				.setStationtype( StationTypeMapper.toStationTypeDto(stationEntity.getStationtypeentity()))
				.setUom(UomMapper.toUomDto(stationEntity.getUomentity()))
				
				
				.setWorkcenter( WorkcenterMapper.toWorkcenterDto(stationEntity.getWorkcenterentity()))
				.setIsdeleted(stationEntity.getIsdeleted().equals("N") ?  "Active" : "Inactive");
	}
	
	public static List<StationDto> toStationDtoList(List<StationEntity> StationEntityList) {
		List<StationDto> StationDtos = new ArrayList<StationDto>();
		
		for(StationEntity StationEntity : StationEntityList) {
			StationDtos.add(toStationDto(StationEntity));
		}
		
		return StationDtos;
	}
	
}