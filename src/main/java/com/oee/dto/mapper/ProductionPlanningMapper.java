package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.oee.dto.ProductionPlanningDto;
import com.oee.entity.ProductionPlanningEntity;

public class ProductionPlanningMapper {

public static List<ProductionPlanningDto> toProductionPlanningDtoActiveList(List<ProductionPlanningEntity> prodPlanningList) {
		
		List<ProductionPlanningDto> prodPlanningDtos = new ArrayList<ProductionPlanningDto>();
		
		for(ProductionPlanningEntity productionPlanningEntity : prodPlanningList) {
		
			prodPlanningDtos.add(toProductionPlanningActiveDto(productionPlanningEntity));
		}
		
		return prodPlanningDtos;
	}
	


public static ProductionPlanningDto toProductionPlanningActiveDto(ProductionPlanningEntity productionPlanningEntity) {
	return new ProductionPlanningDto()
			.setId(productionPlanningEntity.getId())
			.setItem(productionPlanningEntity.getItem().getItemdesc())
			.setSetup(productionPlanningEntity.getSetup().getName())
			.setQty_planned(productionPlanningEntity.getQty_planned())
			.setQty_produced(productionPlanningEntity.getQty_produced())
			.setQty_rejected(productionPlanningEntity.getQty_rejected());
	
}


}
