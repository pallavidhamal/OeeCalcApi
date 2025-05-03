package com.oee.service;

import java.util.List;

import com.oee.dto.SetUpDto;
import com.oee.dto.incoming.SetUpIncomingDto;
import com.oee.entity.SetUpEntity;


public interface SetUpService {

	List<SetUpDto> getAllSetUps();
	
	SetUpDto getSetUpByID(String setUpID);
	
	boolean addSetUp( SetUpIncomingDto setUpIncomingDto);
	boolean editSetUp( SetUpIncomingDto setUpIncomingDto);
	boolean deleteSetUp(String setUpID);
	
}
