
package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.UnitDto;
import com.oee.entity.UnitEntity;

public class UnitMapper {

	public static UnitDto toUnitDto(UnitEntity unitEntity) {
		
		return new UnitDto().setName(unitEntity.getName())
				.setId(unitEntity.getId());

	}

	public static List<UnitDto> toUnitDtoList(List<UnitEntity> UnitEntityList) {
		List<UnitDto> UnitDtos = new ArrayList<UnitDto>();

		for (UnitEntity UnitEntity : UnitEntityList) {
			UnitDtos.add(toUnitDto(UnitEntity));
		}

		return UnitDtos;
	}

}
