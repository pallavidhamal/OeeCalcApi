package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.PlanningShiftWorkIncomingDto;
import com.oee.entity.PlanningShiftWorkEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
import com.oee.repository.PlanningShiftWorkRepository;
import com.oee.service.ItemService;
import com.oee.service.PlanningShiftWorkService;
import com.oee.service.SetUpService;
import com.oee.service.ShiftService;
import com.oee.service.StationService;

@Service
public class PlanningShiftWorkServiceImpl implements PlanningShiftWorkService {

	@Autowired
	PlanningShiftWorkRepository planningShiftWorkRepository;

	@Autowired
	ItemService itemService;
	@Autowired
	SetUpService setupService;

	@Autowired
	StationService stationService;

	private static final Logger logger = LoggerFactory.getLogger(PlanningShiftWorkServiceImpl.class);

	

	
	@Override
	public List<PlanningShiftWorkEntity> getPlanningShiftWorkEntities( List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDtos) 
	{
		
		
		List<PlanningShiftWorkEntity>	planningShiftWorkEntityEntities	= new ArrayList<PlanningShiftWorkEntity>();
		
		planningShiftWorkIncomingDtos.forEach(planningShiftWorkIncomingDto->{
			
			PlanningShiftWorkEntity	planningShiftWorkEntity=null;
			
			if(planningShiftWorkIncomingDto.getId()==null || planningShiftWorkIncomingDto.getId()== "" )
			{
				planningShiftWorkEntity = new PlanningShiftWorkEntity();

			}
			else
			{
			
				planningShiftWorkEntity	= planningShiftWorkRepository.findById(planningShiftWorkIncomingDto.getId()).get();
				
				if (planningShiftWorkEntity == null) {
					planningShiftWorkEntity = new PlanningShiftWorkEntity();

				}
			
				
				
			}
			
			

			planningShiftWorkEntity.setItem(itemService.getItemByID(planningShiftWorkIncomingDto.getItemid()));
		//	planningShiftWorkEntity.setShift(shiftService.getShiftByID(planningShiftWorkIncomingDto.getShiftid()));
		//	planningShiftWorkEntity.setStation(stationService.getStationEntityByID(planningShiftWorkIncomingDto.getStationid()));
			planningShiftWorkEntity.setSetup(setupService.getSetUpById(planningShiftWorkIncomingDto.getSetupid()));
			
			planningShiftWorkEntity.setStation(stationService.getStationEntityByID(planningShiftWorkIncomingDto.getStationid()));
			planningShiftWorkEntity.setItem(itemService.getItemByID(planningShiftWorkIncomingDto.getItemid()));
//			planningShiftWorkEntity.setShift(shiftService.getShiftByID(planningShiftWorkIncomingDto.getShiftid()));
			
			planningShiftWorkEntity.setSetup(setupService.getSetUpById(planningShiftWorkIncomingDto.getSetupid()));
			planningShiftWorkEntity.setSetuptime(planningShiftWorkIncomingDto.getSetuptime());
			
			planningShiftWorkEntity.setCycletime(planningShiftWorkIncomingDto.getCycletime());
			
			planningShiftWorkEntity.setPlannedquantity(planningShiftWorkIncomingDto.getPlannedquantity());
			planningShiftWorkEntity.setPlannedmins(planningShiftWorkIncomingDto.getPlannedmins());
			
			

			planningShiftWorkEntity.setItemtimeutilised(planningShiftWorkIncomingDto.getItemtimeutilised());
			planningShiftWorkEntity.setMachinetimeutilised(planningShiftWorkIncomingDto.getMachinetimeutilised());
			planningShiftWorkEntity.setIsdeleted("N");
			
			planningShiftWorkEntityEntities.add(planningShiftWorkEntity);

			
			});
		
		
		
		return planningShiftWorkEntityEntities;
		
		
	}
	
	
	
}
