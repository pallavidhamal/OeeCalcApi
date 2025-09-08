package com.oee.service;

import java.util.List;

import com.oee.dto.SetUpDto;
import com.oee.dto.StationDto;
import com.oee.dto.incoming.StationIncomingDto;
import com.oee.entity.StationEntity;


public interface StationService {

	List<StationDto> getAllStations();
	
	List<StationDto> getAllActiveStations();
	
	StationEntity 	getStationEntityByID(String stationID);
	StationDto 		getStationByID(String stationID);
	
	boolean addStation( StationIncomingDto stationIncomingDto);
	boolean editStation( StationIncomingDto stationIncomingDto);
	boolean deleteStation(String stationID);
	
	List<StationDto> getStationByWc(String wcid) ;
	
	List<StationDto> getStationByPlanId(String planid) ;

	Object getStationByUnit(String unitid);
	
	

	
}
