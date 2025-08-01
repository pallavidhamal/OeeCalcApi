package com.oee.service;

import java.util.List;
import java.util.Map;

import com.oee.dto.ProductWorkcenteroeeSummaryResponseRecord;
import com.oee.dto.ProductionDto;
import com.oee.dto.incoming.ProductionIncomingDto;

public interface ProductionService {
	
	boolean addProduction(ProductionIncomingDto productionIncomingDto);

	//ProductionEntity getProductionEntityByID(String planId);
	
	List<ProductionDto> getAllProduction();

	ProductionDto getProductionByID(String prodID);

	List<Map<String, String>> getFilterProductions(ProductionIncomingDto productionIncomingDto);

	List<ProductionDto> getPlanVsActual(ProductionIncomingDto productionIncomingDto);

	List<ProductWorkcenteroeeSummaryResponseRecord> getWorkcenterOee(ProductionIncomingDto productionIncomingDto);

	List<ProductionDto> getUnitOee(ProductionIncomingDto productionIncomingDto);

}  
