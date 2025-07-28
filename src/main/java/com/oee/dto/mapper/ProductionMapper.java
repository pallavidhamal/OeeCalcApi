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
	
	public static ProductionDto toProductionDto(ProductionEntity productionEntity) {
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
				.setAvailabilitylunchtime(productionEntity.getAvailability_lunchtime())
				 .setAvailabilityteatime(productionEntity.getAvailability_teatime())
				 .setAvailabilityreviewtime(productionEntity.getAvailability_reviewtime())
				 .setAvailabilityinpectiontime(productionEntity.getAvailability_inpectiontime())
				 .setAvailabilitymachinebreakdown(productionEntity.getAvailability_machinebreakdown())
				 .setAvailabilitysetupchange(productionEntity.getAvailability_setupchange())
				 .setAvailabilitynomaterial(productionEntity.getAvailability_nomaterial())
				 .setAvailabilitynolabour(productionEntity.getAvailability_nolabour())
				 .setAvailabilityinspection(productionEntity.getAvailability_inspection())
				 .setAvailabilitytooling (productionEntity.getAvailability_tooling())
				 .setAvailabilitydrawing (productionEntity.getAvailability_drawing())
				 .setAvailabilityguages (productionEntity.getAvailability_guages())
				 .setAvailabilityotherlosses(productionEntity.getAvailability_otherlosses())
				 .setAvailabilityovertime(productionEntity.getAvailability_overtime())
				 .setAvailabilitytotaltime(productionEntity.getAvailability_totaltime())
				 .setAvailabilitystdloss(productionEntity.getAvailability_stdloss())
				 .setAvailabilityspecloss(productionEntity.getAvailability_specloss())
				 .setAvailabilitytotloss(productionEntity.getAvailability_totloss())
				 .setAvailabilitytime(productionEntity.getAvailability_time())
				 .setProductivitysearching(productionEntity.getProductivity_searching())
				 .setProductivitypersonnal(productionEntity.getProductivity_personnal())
				 .setProductivityrework(productionEntity.getProductivity_rework())  
				 .setProductivityProductionqty(productionEntity.getProductivity_Production_qty())
				 .setProductivitystandardqty(productionEntity.getProductivity_standard_qty())
				 .setRejectionrejectionqty(productionEntity.getRejection_rejection_qty())
				 .setRejectionokqty(productionEntity.getRejection_ok_qty())
				.setProdPlanningDto(ProductionPlanningMapper.toProductionPlanningDtoActiveList(productionEntity.getProductionPlanningEntities()))
				.setIsdeleted(productionEntity.getIsdeleted().equalsIgnoreCase("Y") ? "Active" : "Inactive");
		
	}
	
	
	public static List<ProductionDto> toProductionDtoList(List<ProductionEntity> ProductionEntityList) {
		List<ProductionDto> ProductionDtos = new ArrayList<ProductionDto>();
		
		for(ProductionEntity ProductionEntity : ProductionEntityList) {
			
			ProductionDtos.add(toProductionDto(ProductionEntity));
		}
		
		return ProductionDtos;
	}
	
	
	
}
