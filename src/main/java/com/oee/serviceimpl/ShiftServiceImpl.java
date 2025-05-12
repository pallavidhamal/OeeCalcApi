package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.ShiftDto;
import com.oee.dto.mapper.ShiftMapper;
import com.oee.dto.mapper.WorkcenterMapper;
import com.oee.entity.ShiftEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.ShiftRepository;
import com.oee.service.ShiftService;

@Service
public class ShiftServiceImpl implements ShiftService {

	@Autowired
	ShiftRepository shiftRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ShiftServiceImpl.class);

	
	@Override
	public List<ShiftDto> getAllShifts() {
		
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<ShiftEntity> shiftEntityList = shiftRepository.findAll();
		
		if (shiftEntityList == null) {
			throw BRSException.throwException("Shift List does not exist");
		}
		
		return ShiftMapper.toShiftDtoList(shiftEntityList);
		
	}

	@Override
	public ShiftDto getShiftById(String shiftid) {
		// TODO Auto-generated method stub
		logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		ShiftEntity shiftEntity = shiftRepository.findById(shiftid).get();
		
		if (shiftEntity == null) {
			throw BRSException.throwException("Shift Details does not exist.");
		}
		
		return ShiftMapper.toShiftDto(shiftEntity);
		
		}

		/*
		 * @Override public boolean addShift(ShiftIncomingDto shiftIncomingDto) { //
		 * TODO Auto-generated method stub
		 * 
		 * 
		 * 
		 * if (shiftIncomingDto.getShiftcode() == "") {
		 * 
		 * throw
		 * BRSException.throwException(EntityType.ITEMCODE,ExceptionType.BLANK_VALUE,
		 * "Shift Code");
		 * 
		 * } if (shiftIncomingDto.getShiftdesc() == "") {
		 * 
		 * throw BRSException.throwException(EntityType.ITEMDESC,
		 * ExceptionType.BLANK_VALUE, "Shift Desc");
		 * 
		 * }
		 * 
		 * 
		 * ShiftEntity shiftEntity
		 * =shiftRepository.findByShiftcode(shiftIncomingDto.getShiftcode());
		 * if(shiftEntity != null) { throw BRSException.throwException(EntityType.ITEM,
		 * ExceptionType.ALREADY_EXIST, shiftIncomingDto.getShiftcode());
		 * 
		 * }
		 * 
		 * 
		 * shiftEntity.setShiftcode(shiftIncomingDto.getShiftcode());
		 * shiftEntity.setShiftdesc(shiftIncomingDto.getShiftdesc());
		 * shiftEntity.setIsdeleted("N");
		 * 
		 * shiftEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		 * 
		 * shiftRepository.save(shiftEntity);
		 * 
		 * logger.info("--- Shift Added Successfully ----");
		 * 
		 * return true;
		 * 
		 * }
		 * 
		 * @Override public boolean editShift(ShiftIncomingDto shiftIncomingDto) { //
		 * TODO Auto-generated method stub
		 * 
		 * if (shiftIncomingDto.getShiftcode() == "") {
		 * 
		 * throw BRSException.throwException(EntityType.ITEMCODE,
		 * ExceptionType.BLANK_VALUE, "Shift Code"); } if
		 * (shiftIncomingDto.getShiftdesc() == "") {
		 * 
		 * throw BRSException.throwException(EntityType.ITEMDESC,
		 * ExceptionType.BLANK_VALUE, "Shift Desc"); }
		 * 
		 * // Check If HT Part ID exists in HT Part Entity ShiftEntity shiftEntity =
		 * shiftRepository.findById(shiftIncomingDto.getShiftid()).get();
		 * 
		 * if(shiftEntity == null) { throw BRSException.throwException(EntityType.ITEM,
		 * ExceptionType.ENTITY_NOT_FOUND, shiftIncomingDto.getShiftid()); }
		 * 
		 * shiftEntity.setShiftcode(shiftIncomingDto.getShiftcode());
		 * shiftEntity.setShiftdesc(shiftIncomingDto.getShiftdesc());
		 * shiftEntity.setIsdeleted("N");
		 * 
		 * shiftEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		 * 
		 * shiftRepository.save(shiftEntity);
		 * 
		 * 
		 * return true; }
		 * 
		 * @Override public boolean deleteShift(String shiftid) { // TODO Auto-generated
		 * method stub logger.info("------ delete shift -------");
		 * 
		 * ShiftEntity shiftEntity = shiftRepository.findById(shiftid).get();
		 * 
		 * if (shiftEntity == null) { throw BRSException.throwException(EntityType.ITEM,
		 * ExceptionType.ENTITY_NOT_FOUND, shiftid);
		 * 
		 * }
		 * 
		 * shiftEntity.setIsdeleted(shiftEntity.getIsdeleted().equalsIgnoreCase("Y") ?
		 * "N" : "Y");
		 * shiftEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
		 * 
		 * shiftRepository.save(shiftEntity);
		 * 
		 * logger.info("------ Shift Deleted Successfully ------");
		 * 
		 * return true; }
		 */
	@Override
	public ShiftEntity getShiftByID(String shiftId) {
		// TODO Auto-generated method stub
		 ShiftEntity shiftEntity = shiftRepository.findById(shiftId).get();
		  
		  if (shiftEntity == null) { throw BRSException.throwException(EntityType.ITEM,
		  ExceptionType.ENTITY_NOT_FOUND, shiftId);
		  }
		  return shiftEntity;
	}

	@Override
	public List<ShiftDto> getShiftsByUnit(String unitId) {
		// TODO Auto-generated method stub
		List<ShiftEntity> shiftEntityList = shiftRepository.getShiftsByUnit(unitId);
		
		if (shiftEntityList == null) {
			throw BRSException.throwException("Shift Details does not exist.");
		}
		
		return ShiftMapper.toShiftDtoList(shiftEntityList);	
		}

	
	


}
