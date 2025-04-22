package com.oee.service;

import java.util.List;

import com.oee.dto.ItemDto;
import com.oee.dto.StationDto;
import com.oee.dto.incoming.StationIncomingDto;
import com.oee.entity.ItemEntity;
import com.oee.entity.StationEntity;


public interface StationService {

	List<StationDto> getAllStations();
	
	StationEntity getStationByID(String stationID);
	
	boolean addStation( StationIncomingDto stationIncomingDto);
	boolean editStation( StationIncomingDto stationIncomingDto);
	boolean deleteStation(String stationID);
	
}
