package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.SetUpDto;
import com.oee.entity.SetUpEntity;

public class SetUpMapper {

	public static SetUpDto toSetUpDto(SetUpEntity setUpEntity) {
		return new SetUpDto()
				.setName(setUpEntity.getName())
				.setCycletime(setUpEntity.getCycletime())
				.setItem(setUpEntity.getItementity().getItemcode())
				.setStation(setUpEntity.getStationentity().getName());
	}
	
	public static List<SetUpDto> toSetUpDtoList(List<SetUpEntity> SetUpEntityList) {
		List<SetUpDto> SetUpDtos = new ArrayList<SetUpDto>();
		
		for(SetUpEntity SetUpEntity : SetUpEntityList) {
			SetUpDtos.add(toSetUpDto(SetUpEntity));
		}
		
		return SetUpDtos;
	}
	
}