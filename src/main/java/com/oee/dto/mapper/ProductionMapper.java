package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.ProductionDto;  
import com.oee.entity.ProductionEntity;

public class ProductionMapper {
	public static ProductionDto toOnlyProductionDto(ProductionEntity productionEntity) {
		return new ProductionDto()
				.setId(productionEntity.getId())
				.setProddate(productionEntity.getProddate())
				.setUnitid(productionEntity.getUnitentity().getId())
				.setUnitname(productionEntity.getUnitentity().getName())
				.setWorkcenterid(productionEntity.getWorkcenterentity().getId())
				.setWorkcentername(productionEntity.getWorkcenterentity().getName())
				.setStationid(productionEntity.getStationEntity().getId())
				.setStationname(productionEntity.getStationEntity().getName())
				.setShiftid(productionEntity.getShiftEntity().getId())
				.setShiftname(productionEntity.getShiftEntity().getName())
				.setOperatorid(productionEntity.getOperatorEntity().getId())
				.setOperatorname(productionEntity.getOperatorEntity().getName())
				.setProductivityper(productionEntity.getProductivity_per())
				.setAvailabilityper(productionEntity.getAvailability_per())
				.setRejectionper(productionEntity.getRejection_per())
				.setOeeper(productionEntity.getOee_per())
				.setIsdeleted(productionEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
		
	}
	
	public static List<ProductionDto> toOnlyProductionDtoList(List<ProductionEntity> ProductionEntityList) {
		List<ProductionDto> ProductionDtos = new ArrayList<ProductionDto>();
		
		for(ProductionEntity ProductionEntity : ProductionEntityList) {
			
			ProductionDtos.add(toOnlyProductionDto(ProductionEntity));
		}
		
		return ProductionDtos;
	}
	
	
	
}
