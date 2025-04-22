package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.StationTypeDto;
import com.oee.dto.mapper.StationTypeMapper;
import com.oee.entity.StationTypeEntity;
import com.oee.exception.BRSException;
import com.oee.repository.StationTypeRepository;
import com.oee.service.StationTypeService;

@Service
public class StationTypeServiceImpl implements StationTypeService {

	@Autowired
	StationTypeRepository stationTypeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(StationTypeServiceImpl.class);

	@Override
	public List<StationTypeDto> getAllStationTypes() {
		// TODO Auto-generated method stub
		
		List<StationTypeEntity> stationTypeEntityList = stationTypeRepository.findAll();
		  
		  if (stationTypeEntityList == null) 
		  { 
			  throw  BRSException.throwException("Station Type List does not exist"); 
		  }
		  
		  return StationTypeMapper.toStationTypeDtoList(stationTypeEntityList);
		  
		
	}

	@Override
	public StationTypeEntity getStationTypeByID(String stationTypeid) {
		// TODO Auto-generated method stub
		logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		StationTypeEntity stationTypeEntity = stationTypeRepository.findById(stationTypeid).get();
		
		if (stationTypeEntity == null) {
			throw BRSException.throwException("StationType Details does not exist.");
		}
		
		return stationTypeEntity;	
		}	}

	/*
	 * @Override public List<StationTypeDto> getAllStationTypes() {
	 * 
	 * // TODO Auto-generated method stub
	 * //logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
	 * 
	 * List<StationTypeEntity> stationTypeEntityList = stationTypeRepository.findAll();
	 * 
	 * if (stationTypeEntityList == null) { throw
	 * BRSException.throwException("StationType List does not exist"); }
	 * 
	 * return StationTypeMapper.toStationTypeDtoList(stationTypeEntityList);
	 * 
	 * }
	 * 
	 * @Override public StationTypeEntity getStationTypeByID(String stationTypeid) { // TODO
	 * Auto-generated method stub
	 * logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
	 * 
	 * StationTypeEntity stationTypeEntity = stationTypeRepository.findById(stationTypeid).get();
	 * 
	 * if (stationTypeEntity == null) { throw
	 * BRSException.throwException("StationType Details does not exist."); }
	 * 
	 * return stationTypeEntity; }
	 * 
	 * @Override public boolean addStationType(StationTypeIncomingDto stationTypeIncomingDto) { // TODO
	 * Auto-generated method stub
	 * 
	 * 
	 * if (stationTypeIncomingDto.getStationTypecode() == "") {
	 * 
	 * throw BRSException.throwException(EntityType.ITEMCODE,
	 * ExceptionType.BLANK_VALUE, "StationType Code"); } if (stationTypeIncomingDto.getStationTypedesc()
	 * == "") {
	 * 
	 * throw BRSException.throwException(EntityType.ITEMDESC,
	 * ExceptionType.BLANK_VALUE, "StationType Desc"); }
	 * 
	 * StationTypeEntity stationTypeEntity =
	 * stationTypeRepository.findByStationTypeCode(stationTypeIncomingDto.getStationTypecode());
	 * 
	 * if(stationTypeEntity != null) { throw BRSException.throwException(EntityType.ITEM,
	 * ExceptionType.ALREADY_EXIST, stationTypeIncomingDto.getStationTypecode()); }
	 * 
	 * 
	 * stationTypeEntity.setStationTypecode(stationTypeIncomingDto.getStationTypecode());
	 * stationTypeEntity.setStationTypedesc(stationTypeIncomingDto.getStationTypedesc());
	 * stationTypeEntity.setIsdeleted("N");
	 * 
	 * stationTypeEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
	 * 
	 * stationTypeRepository.save(stationTypeEntity);
	 * 
	 * logger.info("--- StationType Added Successfully ----");
	 * 
	 * return true;
	 * 
	 * }
	 * 
	 * @Override public boolean editStationType(StationTypeIncomingDto stationTypeIncomingDto) { // TODO
	 * Auto-generated method stub
	 * 
	 * if (stationTypeIncomingDto.getStationTypecode() == "") {
	 * 
	 * throw BRSException.throwException(EntityType.ITEMCODE,
	 * ExceptionType.BLANK_VALUE, "StationType Code"); } if (stationTypeIncomingDto.getStationTypedesc()
	 * == "") {
	 * 
	 * throw BRSException.throwException(EntityType.ITEMDESC,
	 * ExceptionType.BLANK_VALUE, "StationType Desc"); }
	 * 
	 * // Check If HT Part ID exists in HT Part Entity StationTypeEntity stationTypeEntity =
	 * stationTypeRepository.findById(stationTypeIncomingDto.getStationTypeid()).get();
	 * 
	 * if(stationTypeEntity == null) { throw BRSException.throwException(EntityType.ITEM,
	 * ExceptionType.ENTITY_NOT_FOUND, stationTypeIncomingDto.getStationTypeid()); }
	 * 
	 * stationTypeEntity.setStationTypecode(stationTypeIncomingDto.getStationTypecode());
	 * stationTypeEntity.setStationTypedesc(stationTypeIncomingDto.getStationTypedesc());
	 * stationTypeEntity.setIsdeleted("N");
	 * 
	 * stationTypeEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
	 * 
	 * stationTypeRepository.save(stationTypeEntity);
	 * 
	 * 
	 * return true; }
	 * 
	 * @Override public boolean deleteStationType(String stationTypeid) { // TODO Auto-generated
	 * method stub logger.info("------ delete stationType -------");
	 * 
	 * StationTypeEntity stationTypeEntity = stationTypeRepository.findById(stationTypeid).get();
	 * 
	 * if (stationTypeEntity == null) { throw BRSException.throwException(EntityType.ITEM,
	 * ExceptionType.ENTITY_NOT_FOUND, stationTypeid);
	 * 
	 * }
	 * 
	 * stationTypeEntity.setIsdeleted(stationTypeEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N"
	 * : "Y");
	 * stationTypeEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
	 * 
	 * stationTypeRepository.save(stationTypeEntity);
	 * 
	 * logger.info("------ StationType Deleted Successfully ------");
	 * 
	 * return true; }
	 */

