package com.oee.service;

import java.util.List;

import com.oee.dto.incoming.ProductionPlanningIncomingDto;
import com.oee.entity.ProductionPlanningEntity;

public interface ProductionPlanningService {

	List<ProductionPlanningEntity> getProductionPlanEntities(List<ProductionPlanningIncomingDto> productionPlanningIncomingDto);

	
}
