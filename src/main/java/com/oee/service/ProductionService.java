package com.oee.service;

import java.util.List;

import com.oee.dto.PlanningDto;
import com.oee.dto.ProductionDto;
import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.entity.ProductionEntity;

public interface ProductionService {
	
	boolean addProduction(ProductionIncomingDto productionIncomingDto);

	//ProductionEntity getProductionEntityByID(String planId);
	
	List<ProductionDto> getAllProduction();

	ProductionDto getProductionByID(String prodID);

}
