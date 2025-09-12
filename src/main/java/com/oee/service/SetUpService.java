package com.oee.service;

import java.util.List;

import com.oee.dto.SetUpDto;
import com.oee.dto.ShiftDto;
import com.oee.dto.incoming.SetUpIncomingDto;
import com.oee.dto.mapper.ShiftMapper;
import com.oee.entity.SetUpEntity;
import com.oee.entity.ShiftEntity;
import com.oee.exception.BRSException;


public interface SetUpService {

	List<SetUpDto> getAllSetUps();
	
	SetUpDto getSetUpByID(String setUpID);
	
	SetUpEntity getSetUpById(String setUpID);
	
	boolean addSetUp( SetUpIncomingDto setUpIncomingDto);
	boolean editSetUp( SetUpIncomingDto setUpIncomingDto);
	boolean deleteSetUp(String setUpID);
	
	
	List<SetUpDto> getSetUpsByItemMachine(String stationid,String itemid) ;

	Object getSetUpByUnit(String unitid);

	boolean checkSetupCombination(SetUpIncomingDto setUpIncomingDto);
}
