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
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.SetUpRepository;
import com.oee.service.ItemService;
import com.oee.service.SetUpService;
import com.oee.service.StationService;
import com.oee.service.UnitService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class SetUpServiceImpl implements SetUpService {

	@Autowired
	SetUpRepository setUpRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	WorkcenterService workcenterService;
	
	@Autowired
	UnitService unitService;
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
	public SetUpDto getSetUpByID(String setUpID) {
		// TODO Auto-generated method stub
		
		SetUpEntity setUpEntity = setUpRepository.findById(setUpID).get();
		
		if (setUpEntity == null) {
			throw BRSException.throwException("SetUp Details does not exist.");
		}
		
		return SetUpMapper.toSetUpDto(setUpEntity);	
	}
		
		

	@Override
	public boolean addSetUp(SetUpIncomingDto setUpIncomingDto) {
		// TODO Auto-generated method stub

		 logger.info("--- addSetUp ----"+setUpIncomingDto.toString());
		List<SetUpEntity> setUpEntityList = setUpRepository.getSetUpsByUnitWcItemMachineName(setUpIncomingDto.getUnitid(),setUpIncomingDto.getWorkcenterid(),setUpIncomingDto.getItemId(),setUpIncomingDto.getStationid(),setUpIncomingDto.getName());
		
		if (setUpEntityList.size()!=0) {
			
			 logger.info("--- DUPLICATE_ENTITY for ----"+setUpIncomingDto.getName());

			throw BRSException.throwException(EntityType.SETUP, ExceptionType.DUPLICATE_ENTITY, setUpIncomingDto.getName());
		}	  
		 
		  SetUpEntity setUpEntity = new SetUpEntity();
		 
		  setUpEntity.setName(setUpIncomingDto.getName());
		  setUpEntity.setCycletime(setUpIncomingDto.getCycletime());
		  
		  ItemEntity itemEntity =  itemService.getItemByID(setUpIncomingDto.getItemId());
		 
		  StationEntity stationEntity =  stationService.getStationEntityByID(setUpIncomingDto.getStationid());

		  UnitEntity unitEntity=unitService.getEntityById(setUpIncomingDto.getUnitid());

		  WorkcenterEntity workcentreEntity=workcenterService.getWorkcenterByID(setUpIncomingDto.getWorkcenterid());
		
		  setUpEntity.setUnitentity(unitEntity);
		  setUpEntity.setWorkcenterentity(workcentreEntity);
		  setUpEntity.setItementity(itemEntity);
		  setUpEntity.setStationentity(stationEntity);
		  setUpEntity.setIsdeleted("N");
		  
		  setUpEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
		  logger.info("--- before saving set up ----");
		  
		  
		  setUpRepository.save(setUpEntity);
		  
		  logger.info("--- SetUp Added Successfully ----");
		 
		  
		  return true;
		 
	}

	@Override
	public boolean editSetUp(SetUpIncomingDto setUpIncomingDto) {
		// TODO Auto-generated method stub
		  SetUpEntity setUpEntity = new SetUpEntity();
		 
		  
		  setUpEntity  = setUpRepository.findById(setUpIncomingDto.getSetupid()).get();
			
		  if(setUpEntity == null) 
		  { throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, setUpIncomingDto.getSetupid()); 
		  }
			 
		  UnitEntity unitEntity =  unitService.getEntityById(setUpIncomingDto.getUnitid());	
		  if(unitEntity == null) 
		  { throw BRSException.throwException(EntityType.UNIT, ExceptionType.ENTITY_NOT_FOUND, setUpIncomingDto.getUnitid()); 
		  }
		  ItemEntity itemEntity =  itemService.getItemByID(setUpIncomingDto.getItemId());
		  if(itemEntity == null) 
		  { throw BRSException.throwException(EntityType.ITEM, ExceptionType.ENTITY_NOT_FOUND, setUpIncomingDto.getItemId()); 
		  }
		  StationEntity stationEntity =  stationService.getStationEntityByID(setUpIncomingDto.getStationid());
		  if(stationEntity == null) 
		  { throw BRSException.throwException(EntityType.STATION, ExceptionType.ENTITY_NOT_FOUND, setUpIncomingDto.getStationid()); 
		  }
		  WorkcenterEntity workcentreEntity=workcenterService.getWorkcenterByID(setUpIncomingDto.getWorkcenterid());
		  if(workcentreEntity == null) 
		  { throw BRSException.throwException(EntityType.WORKCENTER, ExceptionType.ENTITY_NOT_FOUND, setUpIncomingDto.getWorkcenterid()); 
		  }
		  
			
		  if(setUpRepository.existsByUnitentityAndWorkcenterentityAndItementityAndStationentityAndNameAndIdNot
				  (unitEntity,workcentreEntity,itemEntity,stationEntity,setUpIncomingDto.getName(),setUpIncomingDto.getSetupid()))
		  {
				throw BRSException.throwException(EntityType.SETUP, ExceptionType.DUPLICATE_ENTITY, setUpIncomingDto.getName());
		  }	
		  
		  setUpEntity.setName(setUpIncomingDto.getName());
		  setUpEntity.setCycletime(setUpIncomingDto.getCycletime());
		  setUpEntity.setWorkcenterentity(workcentreEntity);
		  setUpEntity.setItementity(itemEntity);
		  setUpEntity.setStationentity(stationEntity);
		  setUpEntity.setIsdeleted("N");
		  
		  setUpEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
		  logger.info("--- before saving set up ----");
		  
		  
		  setUpRepository.save(setUpEntity);
		  
		  logger.info("--- SetUp updeated Successfully ----");
		 
		  
		  return true;
	}

	@Override
	public boolean deleteSetUp(String setUpid) {
		// TODO Auto-generated method stub
		logger.info("------ delete setup -------");
		
		SetUpEntity setUpEntity  = setUpRepository.findById(setUpid).get();
		
		if (setUpEntity == null) {
			throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, setUpid);	
			
		}
		
		setUpEntity.setIsdeleted(setUpEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		setUpEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		
		setUpRepository.save(setUpEntity);
		logger.info("------ setUpEntity Deleted Successfully ------");
		
		return true;		
	}

	@Override
	public List<SetUpDto> getSetUpsByItemMachine(String stationid,String itemid) 
	{
		// TODO Auto-generated method stub
		
		List<SetUpEntity> setUpEntityList = setUpRepository.getSetUpsByItemMachine( stationid, itemid);
		
		if (setUpEntityList == null) {
			throw BRSException.throwException("setup list does not exist.");
		}
		
		return SetUpMapper.toSetUpDtoList(setUpEntityList);	
		
	}
		

	@Override
	public SetUpEntity getSetUpById(String setUpID) {
		// TODO Auto-generated method stub
		
		SetUpEntity setUpEntity = setUpRepository.findById(setUpID).get();
		
		if (setUpEntity == null) {
			throw BRSException.throwException("SetUp Details does not exist.");
		}
		
		return setUpEntity;	
		}

	@Override
	public Object getSetUpByUnit(String unitid) {
		// TODO Auto-generated method stub
		List<SetUpEntity> setUpEntityList = setUpRepository.findSetupByUnit(unitid);
		
		if (setUpEntityList == null) {
			throw BRSException.throwException("SetUp List does not exist");
		}
		
		return SetUpMapper.toSetUpDtoList(setUpEntityList);
	}

	
		
}
