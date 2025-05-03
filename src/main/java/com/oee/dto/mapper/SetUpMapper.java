package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.SetUpDto;
import com.oee.entity.SetUpEntity;

public class SetUpMapper {

	public static SetUpDto toSetUpDto(SetUpEntity setUpEntity) {
		return new SetUpDto()
				.setId(setUpEntity.getId())
				.setName(setUpEntity.getName())
				.setCycletime(setUpEntity.getCycletime())
				.setItem(setUpEntity.getItementity().getItemcode())
				.setItemdesc(setUpEntity.getItementity().getItemdesc())
				.setStation(setUpEntity.getStationentity().getName())
				.setUom(setUpEntity.getStationentity().getUomentity().getName());
		
	}
	
	public static List<SetUpDto> toSetUpDtoList(List<SetUpEntity> SetUpEntityList) {
		List<SetUpDto> SetUpDtos = new ArrayList<SetUpDto>();
		
		for(SetUpEntity SetUpEntity : SetUpEntityList) {
			SetUpDtos.add(toSetUpDto(SetUpEntity));
		}
		
		return SetUpDtos;
	}
	
}