package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.SetUpDto;
import com.oee.dto.incoming.SetUpIncomingDto;
import com.oee.dto.mapper.SetUpMapper;
import com.oee.entity.ItemEntity;
import com.oee.entity.SetUpEntity;
import com.oee.entity.StationEntity;
import com.oee.exception.BRSException;
import com.oee.repository.SetUpRepository;
import com.oee.service.ItemService;
import com.oee.service.SetUpService;
import com.oee.service.StationService;
import com.oee.util.AuthenticationService;

@Service
public class SetUpServiceImpl implements SetUpService {

	@Autowired
	SetUpRepository setUpRepository;
	
	@Autowired
	SetUpService setUpService;
	
	@Autowired
	ItemService itemService;
	
	
	@Autowired
	StationService stationService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(SetUpServiceImpl.class);

	
	@Override
	public List<SetUpDto> getAllSetUps() {
		 
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<SetUpEntity> setUpEntityList = setUpRepository.findAll();
		
		if (setUpEntityList == null) {
			throw BRSException.throwException("SetUp List does not exist");
		}
		
		return SetUpMapper.toSetUpDtoList(setUpEntityList);
		
	}

	@Override
	public SetUpEntity getSetUpByID(String setUpID) {
		// TODO Auto-generated method stub
		
		SetUpEntity setUpEntity = setUpRepository.findById(setUpID).get();
		
		if (setUpEntity == null) {
			throw BRSException.throwException("SetUp Details does not exist.");
		}
		
		return setUpEntity;	
		}
		
		

	@Override
	public boolean addSetUp(SetUpIncomingDto setUpIncomingDto) {
		// TODO Auto-generated method stub

		
		  
		  SetUpEntity setUpEntity = new SetUpEntity();
		 
		  setUpEntity.setName(setUpIncomingDto.getName());
		  setUpEntity.setCycletime(setUpIncomingDto.getCycletime());
		  
		  
		  ItemEntity itemEntity =  itemService.getItemByID(setUpIncomingDto.getItemId());
		 
		  StationEntity stationEntity =  stationService.getStationByID(setUpIncomingDto.getStationId());

		  
		  setUpEntity.setItementity(itemEntity);
		  setUpEntity.setStationentity(stationEntity);
		  setUpEntity.setIsdeleted("N");
		  
		  setUpEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
		  setUpRepository.save(setUpEntity);
		  
		  logger.info("--- SetUp Added Successfully ----");
		 
		  
		  return true;
		 
	}

	@Override
	public boolean editSetUp(SetUpIncomingDto setUpIncomingDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSetUp(String setUpid) {
		// TODO Auto-generated method stub
		return false;
	}

}
