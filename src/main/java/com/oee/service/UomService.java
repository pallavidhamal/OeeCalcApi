package com.oee.service;

import java.util.List;

import com.oee.dto.UomDto;
import com.oee.entity.UomEntity;


public interface UomService {

	List<UomDto> getAllUoms();
	
	UomEntity getUomByID(String uomID);
	
	/*
	 * boolean addUom( UomIncomingDto uomIncomingDto); boolean
	 * editUom( UomIncomingDto uomIncomingDto); boolean
	 * deleteUom(String uomID);
	 */
	
}
