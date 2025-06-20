package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.StationDto;
import com.oee.dto.incoming.StationIncomingDto;
import com.oee.dto.mapper.StationMapper;
import com.oee.entity.SetUpEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.StationTypeEntity;
import com.oee.entity.UomEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.StationRepository;
import com.oee.repository.StationTypeRepository;
import com.oee.service.StationService;
import com.oee.service.StationTypeService;
import com.oee.service.UomService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationRepository stationRepository;
	
	@Autowired
	StationTypeService stationTypeService;
	
	@Autowired
	WorkcenterService workcenterService;
	
	
	@Autowired
	UomService uomService;
	
	@Autowired
	StationTypeRepository stationTypeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);

	
	@Override
	public List<StationDto> getAllStations() {
		 
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<StationEntity> stationEntityList = stationRepository.findAll();
		
		if (stationEntityList == null) {
			throw BRSException.throwException("Station List does not exist");
		}
		
		return StationMapper.toStationDtoList(stationEntityList);
		
	}
	
	@Override
	public List<StationDto> getAllActiveStations() {
		 
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<StationEntity> stationEntityList = stationRepository.findByIsdeleted("N");
		
		if (stationEntityList == null) {
			throw BRSException.throwException("Station List does not exist");
		}
		
		return StationMapper.toStationDtoList(stationEntityList);
		
	}

	@Override
	public StationDto getStationByID(String stationID) {
		// TODO Auto-generated method stub
		
		StationEntity stationEntity = stationRepository.findById(stationID).get();
		
		if (stationEntity == null) {
			throw BRSException.throwException("Station Details does not exist.");
		}
		
		return StationMapper.toStationDto(stationEntity);	
		}
	
	
	@Override
	public StationEntity getStationEntityByID(String stationID) {
		// TODO Auto-generated method stub
		
		StationEntity stationEntity = stationRepository.findById(stationID).get();
		
		if (stationEntity == null) {
			throw BRSException.throwException("Station Details does not exist.");
		}
		
		return stationEntity;	
		}	
		

	@Override
	public boolean addStation(StationIncomingDto stationIncomingDto) {
		// TODO Auto-generated method stub

		
		  
		  StationEntity stationEntity = stationRepository.findByName(stationIncomingDto.getName());
		 
		 
		  
		  if(stationEntity != null) {
				throw BRSException.throwException(EntityType.STATION, ExceptionType.DUPLICATE_ENTITY, stationIncomingDto.getName());
			}else {
				stationEntity = new StationEntity();
			}
		  
		  StationTypeEntity stationTypeEntity =  stationTypeService.getStationTypeByID(stationIncomingDto.getStationtypeid());
		  
		  UomEntity uomEntity =  uomService.getUomByID(stationIncomingDto.getUomid());

		  WorkcenterEntity workcentreEntity=workcenterService.getWorkcenterByID(stationIncomingDto.getWorkcenterid());
		
		  
		  stationEntity.setName(stationIncomingDto.getName());
		  stationEntity.setStationtypeentity(stationTypeEntity);
		  stationEntity.setUomentity(uomEntity);
		  stationEntity.setWorkcenterentity(workcentreEntity);
		  stationEntity.setIsdeleted("N");
		  
		  stationEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
	//	  stationRepository.save(stationEntity);
		  
		  logger.info("--- Station Added Successfully ----");
		 
		  
		  return true;
		 
	}

	@Override
	public boolean editStation(StationIncomingDto stationIncomingDto) {
		// TODO Auto-generated method stub
		
		
		  StationEntity stationEntity = new StationEntity();
		  
		  
		  stationEntity  = stationRepository.findById(stationIncomingDto.getStationid()).get();
		  
		  			
			if(stationEntity == null) {
				throw BRSException.throwException(EntityType.STATION, ExceptionType.ENTITY_NOT_FOUND, stationIncomingDto.getStationid());
			}
		  
		 
		  stationEntity.setName(stationIncomingDto.getName());
		  
		  StationTypeEntity stationTypeEntity =  stationTypeService.getStationTypeByID(stationIncomingDto.getStationtypeid());
		 
		  UomEntity uomEntity =  uomService.getUomByID(stationIncomingDto.getUomid());

		  WorkcenterEntity workcentreEntity=workcenterService.getWorkcenterByID(stationIncomingDto.getWorkcenterid());
		
		  
		  stationEntity.setStationtypeentity(stationTypeEntity);
		  stationEntity.setUomentity(uomEntity);
		  stationEntity.setWorkcenterentity(workcentreEntity);
		  stationEntity.setIsdeleted("N");
		  
		  stationEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		  
		  stationRepository.save(stationEntity);
		  
		  logger.info("--- Station Added Successfully ----");
		 
		  
		  return true;	}

	@Override
	public boolean deleteStation(String stationid) {
		// TODO Auto-generated method stub
		logger.info("------ delete station -------");
		
		StationEntity stationEntity  = stationRepository.findById(stationid).get();
		
		if (stationEntity == null) {
			throw BRSException.throwException(EntityType.STATION, ExceptionType.ENTITY_NOT_FOUND, stationid);	
			
		}
		
		stationEntity.setIsdeleted(stationEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		stationEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		
		stationRepository.save(stationEntity);
		
		logger.info("------ setUpEntity Deleted Successfully ------");
		
		return true;
	}

}
