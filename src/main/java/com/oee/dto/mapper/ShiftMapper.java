package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.ShiftDto;
import com.oee.entity.ShiftEntity;

public class ShiftMapper {

	public static ShiftDto toShiftDto(ShiftEntity shiftEntity) {
		return new ShiftDto()
				.setShiftid(shiftEntity.getId())
				.setShifthour(shiftEntity.getShifthour())
				.setName(shiftEntity.getName())
				.setIsdeleted(shiftEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
				
	}
	
	public static List<ShiftDto> toShiftDtoList(List<ShiftEntity> ShiftEntityList) {
		List<ShiftDto> ShiftDtos = new ArrayList<ShiftDto>();
		
		for(ShiftEntity ShiftEntity : ShiftEntityList) {
			ShiftDtos.add(toShiftDto(ShiftEntity));
		}
		
		return ShiftDtos;
	}
	
}
