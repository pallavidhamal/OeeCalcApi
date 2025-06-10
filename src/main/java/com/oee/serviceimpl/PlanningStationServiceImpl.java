package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.PlanningStationIncomingDto;
import com.oee.entity.PlanningStationsEntity;
import com.oee.repository.PlanningRepository;
import com.oee.service.PlanningStationService;
import com.oee.service.StationService;

@Service
public class PlanningStationServiceImpl implements PlanningStationService {

	@Autowired
	PlanningRepository planningRepository;


	@Autowired
	StationService stationService;

	private static final Logger logger = LoggerFactory.getLogger(PlanningStationServiceImpl.class);

	

	
	@Override
	public List<PlanningStationsEntity> getPlanningStationEntities(
			List<PlanningStationIncomingDto> planningStationIncomingDtos) 
	{
		
		List<PlanningStationsEntity>	planningStationEntityEntities	= new ArrayList<PlanningStationsEntity>();
		
		planningStationIncomingDtos.forEach(planningStationIncomingDto->{
			
			PlanningStationsEntity	planningStationEntity	= new PlanningStationsEntity();
			
			planningStationEntity.setStation(stationService.getStationEntityByID(planningStationIncomingDto.getStationid()));
			planningStationEntity.setIsdeleted("N");
			planningStationEntity.setTimeutilised(planningStationIncomingDto.getTimeutilised());
		
			planningStationEntityEntities.add(planningStationEntity);
			
			});
		
		
		
		return planningStationEntityEntities;
		
		
	}
	
	
	
}
