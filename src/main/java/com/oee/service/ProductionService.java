package com.oee.service;

import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.entity.ProductionEntity;

public interface ProductionService {
	
	boolean addProduction(ProductionIncomingDto productionIncomingDto);

	//ProductionEntity getProductionEntityByID(String planId);
}
