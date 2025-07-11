package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.WorkcenterDto;
import com.oee.dto.incoming.WorkcenterIncomingDto;
import com.oee.dto.mapper.WorkcenterMapper;
import com.oee.entity.StationTypeEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.WorkcenterRepository;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class WorkcenterServiceImpl implements WorkcenterService {

	@Autowired
	WorkcenterRepository workcenterRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkcenterServiceImpl.class);

	
	@Override
	public List<WorkcenterDto> getAllWorkcenters() {
		
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<WorkcenterEntity> workcenterEntityList = workcenterRepository.findAll();
		
		if (workcenterEntityList == null) {
			throw BRSException.throwException("Workcenter List does not exist");
		}
		
		return WorkcenterMapper.toWorkcenterDtoList(workcenterEntityList);
		
	}

	@Override
	public WorkcenterEntity getWorkcenterByID(String wcID) {  
		// TODO Auto-generated method stub
		logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		WorkcenterEntity workcentreEntity = workcenterRepository.findById(wcID).get();
		
		if (workcentreEntity == null) {
			throw BRSException.throwException("Workcentre Details does not exist.");
		}
		
		return workcentreEntity;	
	}
	
	@Override
	public WorkcenterEntity getActiveWorkcenterByID(String wcID) {  
		// TODO Auto-generated method stub
		logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		WorkcenterEntity workcentreEntity = workcenterRepository.findByIdAndIsdeleted(wcID,"N");
		
		if (workcentreEntity == null) {
			throw BRSException.throwException("Workcentre Details does not exist.");
		}
		
		return workcentreEntity;	
	}

	@Override
	public List<WorkcenterDto> getAllActiveWorkcenters() {
		
		// TODO Auto-generated method stub
		//logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");
		
		List<WorkcenterEntity> workcenterEntityList = workcenterRepository.findByIsdeleted("N");
		
		if (workcenterEntityList == null) {
			throw BRSException.throwException("Workcenter List does not exist");
		}
		
		return WorkcenterMapper.toWorkcenterDtoList(workcenterEntityList);
		
	}

	@Override
	public List<WorkcenterDto> getWorkcenterByUnit(String UnitID) {
		// TODO Auto-generated method stub
		List<WorkcenterEntity> workcenterEntityList = workcenterRepository.getWorkcenterByUnit(UnitID);
		
		if (workcenterEntityList == null) {
			throw BRSException.throwException("Workcentre Details does not exist.");
		}
		
		return WorkcenterMapper.toWorkcenterDtoList(workcenterEntityList);
		
	}
	}



