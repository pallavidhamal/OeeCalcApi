
package com.oee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.UnitDto;
import com.oee.dto.incoming.UnitIncomingDto;
import com.oee.dto.mapper.UnitMapper;
import com.oee.dto.mapper.UnitMapper;
import com.oee.entity.UnitEntity;
import com.oee.entity.UnitEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.UnitRepository;
import com.oee.service.UnitService;
import com.oee.util.AuthenticationService;

@Service
public class UnitServiceImpl implements UnitService {

	private static final Logger logger = LoggerFactory.getLogger(UnitServiceImpl.class);
	
	@Autowired
	UnitRepository unitRepository;

	public UnitServiceImpl(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}
	
	@Override
	public UnitDto getById(String id) {
		// TODO Auto-generated method stub
		Optional<UnitEntity> unitEntity = unitRepository.findById(id);
		
		return UnitMapper.toUnitDto(unitEntity.get());
	}

	@Override
	public List<UnitDto> get() {
		// TODO Auto-generated method stub
		List<UnitEntity> unitEntities = unitRepository.findAll();
		
		return UnitMapper.toUnitDtoList(unitEntities);
	}

	@Override
	public List<UnitDto> getActive() {
		// TODO Auto-generated method stub
		List<UnitEntity> unitEntities = unitRepository.findByIsdeleted("N");
		
		return UnitMapper.toUnitDtoList(unitEntities);
	}

	@Override
	public UnitEntity getEntityById(String id) {
		// TODO Auto-generated method stub
		UnitEntity unitEntity = unitRepository.findById(id).get();
		
		if (unitEntity == null) { 
			  throw BRSException.throwException(EntityType.UNIT, ExceptionType.ENTITY_NOT_FOUND, id);
		  }
		
		return unitEntity;
	}

	@Override
	public UnitEntity getActiveEntityById(String id) {
		// TODO Auto-generated method stub
		UnitEntity unitEntity = unitRepository.findByIdAndIsdeleted(id,"N");
		
		if (unitEntity == null) { 
			  throw BRSException.throwException(EntityType.UNIT, ExceptionType.ENTITY_NOT_FOUND, id);
		  }
		
		return unitEntity;
	}


}
