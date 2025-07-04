package com.oee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.OperatorDto;
import com.oee.dto.mapper.OperatorMapper;
import com.oee.entity.OperatorEntity;
import com.oee.entity.UnitEntity;
import com.oee.exception.BRSException;
import com.oee.repository.OperatorRepository;
import com.oee.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorRepository operatorRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorServiceImpl.class);

	@Override
	public List<OperatorDto> getAllOperators() {
		// TODO Auto-generated method stub
		
		List<OperatorEntity> operatorEntityList = operatorRepository.findAll();
		  
		  if (operatorEntityList == null) 
		  { 
			  throw  BRSException.throwException("UOM List does not exist"); 
		  }
		  
		  return OperatorMapper.toOperatorDtoList(operatorEntityList);
		  
		
	}
	
	@Override
	public List<OperatorDto> getAllActiveOperators() {
		// TODO Auto-generated method stub
		
		List<OperatorEntity> operatorEntityList = operatorRepository.findByIsdeleted("N");
		  
		  if (operatorEntityList == null) 
		  { 
			  throw  BRSException.throwException("UOM List does not exist"); 
		  }
		  
		  return OperatorMapper.toOperatorDtoList(operatorEntityList);
		  
		
	}

	@Override
	public OperatorEntity getOperatorByID(String operatorid) {
		// TODO Auto-generated method stub
		logger.info("----- OperatorServiceImpl getOperatorByID -----");
		
		OperatorEntity operatorEntity = operatorRepository.findById(operatorid).get();
		
		if (operatorEntity == null) {
			throw BRSException.throwException("Operator Details does not exist.");
		}
		
		return operatorEntity;	
		}

	@Override
	public Object getById(String id) {
		// TODO Auto-generated method stub
		Optional<OperatorEntity> operatorEntity = operatorRepository.findById(id);
		
		return operatorEntity.get();
	}	}

	