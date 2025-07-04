package com.oee.service;

import java.util.List;

import com.oee.dto.OperatorDto;
import com.oee.entity.OperatorEntity;


public interface OperatorService {

	List<OperatorDto> getAllOperators();
	
	List<OperatorDto> getAllActiveOperators();
	
	OperatorEntity getOperatorByID(String uomID);

	Object getById(String id);
	
	/*
	 * boolean addOperator( OperatorIncomingDto uomIncomingDto); boolean
	 * editOperator( OperatorIncomingDto uomIncomingDto); boolean
	 * deleteOperator(String uomID);
	 */
	
}
