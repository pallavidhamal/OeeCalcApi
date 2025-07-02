package com.oee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.incoming.PlanningShiftWorkIncomingDto;
import com.oee.dto.mapper.PlanningMapper;
import com.oee.dto.mapper.PlanningShiftWorkMapper;
import com.oee.entity.PlanningEntity;
import com.oee.entity.PlanningShiftWorkEntity;
import com.oee.entity.ShiftEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
import com.oee.repository.PlanningShiftWorkRepository;
import com.oee.repository.StationRepository;
import com.oee.service.ItemService;
import com.oee.service.PlanningShiftWorkService;
import com.oee.service.SetUpService;
import com.oee.service.ShiftService;
import com.oee.service.StationService;
import com.oee.util.AuthenticationService;

@Service
public class PlanningShiftWorkServiceImpl implements PlanningShiftWorkService {

	@Autowired
	PlanningShiftWorkRepository planningShiftWorkRepository;

	@Autowired
	PlanningRepository planningRepository;
	
	@Autowired
	StationRepository stationRepository;
	
	

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
	
	
	
	@Override
	public List<PlanningShiftWorkEntity> updateAndDeletePlanningShiftWorkEntities( 
						List<PlanningShiftWorkIncomingDto> planningShiftWorkIncomingDtos,
						List<PlanningShiftWorkIncomingDto> planningShiftWorkDeleteIncomingDtos) 
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
		
			planningShiftWorkDeleteIncomingDtos.forEach(planningShiftWorkDeleteIncomingDto->{
				
				PlanningShiftWorkEntity	planningShiftWorkDeleteEntity=null;
				if(planningShiftWorkDeleteIncomingDto.getId()==null || planningShiftWorkDeleteIncomingDto.getId()== "" )
				{
					planningShiftWorkDeleteEntity = new PlanningShiftWorkEntity();
				}
				else
				{
					planningShiftWorkDeleteEntity	= planningShiftWorkRepository.findById(planningShiftWorkDeleteIncomingDto.getId()).get();
					if (planningShiftWorkDeleteEntity == null) {
						planningShiftWorkDeleteEntity = new PlanningShiftWorkEntity();
					}
				}
				
				planningShiftWorkDeleteEntity.setIsdeleted("Y");
				
				planningShiftWorkEntityEntities.add(planningShiftWorkDeleteEntity);

				
			});
		
		
		
		return planningShiftWorkEntityEntities;
	}
	
	
	@Override
	public boolean deletePlanningShiftWork(String id) {
		// TODO Auto-generated method stub
		logger.info("------ delete setup -------");

		PlanningShiftWorkEntity planningShiftWorkEntity = planningShiftWorkRepository.findById(id).get();

		if (planningShiftWorkEntity == null) {
			throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, id);

		}

		planningShiftWorkEntity.setIsdeleted(planningShiftWorkEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		planningShiftWorkEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());

		planningShiftWorkRepository.save(planningShiftWorkEntity);
		logger.info("------ planningEntity Deleted Successfully ------");

		return true;
	}



	@Override
	public Object getShiftWorkDtlsByPlanAndStation(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		PlanningEntity planEntity = new PlanningEntity();
		planEntity  = planningRepository.findById(planningIncomingDto.getId()).get();
		
		
		StationEntity stationEntity = new StationEntity();
		stationEntity  = stationRepository.findById(planningIncomingDto.getStationid()).get();
		
		/*
		 * WorkcenterEntity wsEntity = new WorkcenterEntity();
		 * 
		 * logger.info("------ ws id -------"+planningIncomingDto.getWorkcenterid());
		 * 
		 * if((planningIncomingDto.getWorkcenterid()!=null)&&(!planningIncomingDto.
		 * getWorkcenterid().equals("0"))) wsEntity =
		 * wsRepository.findById(planningIncomingDto.getWorkcenterid()).get();
		 */
		
		List<PlanningShiftWorkEntity> planningShiftWorkEntityLst =planningShiftWorkRepository.findByPlanningentityAndStation(planEntity,stationEntity);
		
		return PlanningShiftWorkMapper.toPlanningDtoList(planningShiftWorkEntityLst);
				
	}
	
	
	
}
