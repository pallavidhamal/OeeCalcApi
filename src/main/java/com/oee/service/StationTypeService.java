package com.oee.service;

import java.util.List;

import com.oee.dto.StationTypeDto;
import com.oee.entity.StationTypeEntity;


public interface StationTypeService {

	List<StationTypeDto> getAllStationTypes();
	List<StationTypeDto> getAllActiveStationTypes();
	StationTypeEntity getStationTypeByID(String stationID);
	
	/*
	 * boolean addStationType( StationTypeIncomingDto stationIncomingDto); boolean
	 * editStationType( StationTypeIncomingDto stationIncomingDto); boolean
	 * deleteStationType(String stationID);
	 */
	
}
