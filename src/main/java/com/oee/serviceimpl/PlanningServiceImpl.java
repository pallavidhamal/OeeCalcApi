package com.oee.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.PlanningDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.mapper.PlanningMapper;
import com.oee.entity.PlanningEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
import com.oee.repository.UnitRepository;
import com.oee.repository.WorkcenterRepository;
import com.oee.service.ItemService;
import com.oee.service.PlanningService;
import com.oee.service.PlanningShiftWorkService;
import com.oee.service.StationService;
import com.oee.service.UnitService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class PlanningServiceImpl implements PlanningService {

	@Autowired
	PlanningRepository planningRepository;

	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	WorkcenterRepository wsRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	WorkcenterService wsService;

	@Autowired
	StationService stationService;
	
	@Autowired
	PlanningShiftWorkService planningShiftWorkService;

	private static final Logger logger = LoggerFactory.getLogger(PlanningServiceImpl.class);

	@Override
	public List<PlanningDto> getAllPlannings() {

		// TODO Auto-generated method stub
		// logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");

		List<PlanningEntity> planningEntityList = planningRepository.findAll();

		if (planningEntityList == null) {
			throw BRSException.throwException("Planning List does not exist");
		}
		return PlanningMapper.toOnlyPlanningDtoList(planningEntityList);

	}

	
	@Override
	public List<PlanningDto> getAllPlanningsWDetails() {

		// TODO Auto-generated method stub
		// logger.info("----- FittingTypeServiceImpl getAllFittingTypeList -----");

		List<PlanningEntity> planningEntityList = planningRepository.findAll();

		if (planningEntityList == null) {
			throw BRSException.throwException("Planning List does not exist");
		}
		return PlanningMapper.toPlanningDtoList(planningEntityList);

	}
	
	@Override
	public PlanningDto getPlanningByID(String planningID) {
		// TODO Auto-generated method stub

		PlanningEntity planningEntity = planningRepository.findById(planningID).get();

		if (planningEntity == null) {
			throw BRSException.throwException("Planning Details does not exist.");
		}

		return PlanningMapper.toPlanningDto(planningEntity);
	}

	@Override
	public boolean addPlanning(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub

		PlanningEntity planningEntity = new PlanningEntity();
		
		
		planningEntity.setFromdate(planningIncomingDto.getFromdate());
		planningEntity.setTodate(planningIncomingDto.getTodate());
		planningEntity.setTimepershift(planningIncomingDto.getTimepershift());
		planningEntity.setPlanningSiftWorkEntities(planningShiftWorkService.getPlanningShiftWorkEntities(planningIncomingDto.getPlanningShiftWorkIncomingDto()));
		planningEntity.setUnitentity(unitService.getEntityById(planningIncomingDto.getUnitid()));
		planningEntity.setWorkcenterentity(wsService.getWorkcenterByID(planningIncomingDto.getWorkcenterid()));
		planningEntity.setIsdeleted("N");
		planningEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
   
		logger.info("--- before saving set up ----");

		planningRepository.save(planningEntity);

		logger.info("--- Planning Added Successfully ----");

		return true;
		

	}

	/*
	 * @Override public boolean editPlanning(PlanningIncomingDto
	 * planningIncomingDto) { // TODO Auto-generated method stub PlanningEntity
	 * planningEntity = new PlanningEntity();
	 * 
	 * planningEntity =
	 * planningRepository.findById(planningIncomingDto.getSetupid()).get();
	 * 
	 * if(planningEntity == null) { throw
	 * BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND,
	 * planningIncomingDto.getSetupid()); }
	 * 
	 * planningEntity.setName(planningIncomingDto.getName());
	 * planningEntity.setCycletime(planningIncomingDto.getCycletime());
	 * 
	 * ItemEntity itemEntity =
	 * itemService.getItemByID(planningIncomingDto.getItemId());
	 * 
	 * StationEntity stationEntity =
	 * stationService.getStationEntityByID(planningIncomingDto.getStationId());
	 * 
	 * 
	 * planningEntity.setItementity(itemEntity);
	 * planningEntity.setStationentity(stationEntity);
	 * planningEntity.setIsdeleted("N");
	 * 
	 * planningEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin())
	 * ;
	 * 
	 * logger.info("--- before saving set up ----");
	 * 
	 * 
	 * planningRepository.save(planningEntity);
	 * 
	 * logger.info("--- Planning updeated Successfully ----");
	 * 
	 * 
	 * return true; }
	 */

	@Override
	public boolean deletePlanning(String planningid) {
		// TODO Auto-generated method stub
		logger.info("------ delete setup -------");

		PlanningEntity planningEntity = planningRepository.findById(planningid).get();

		if (planningEntity == null) {
			throw BRSException.throwException(EntityType.SETUP, ExceptionType.ENTITY_NOT_FOUND, planningid);

		}

		planningEntity.setIsdeleted(planningEntity.getIsdeleted().equalsIgnoreCase("Y") ? "N" : "Y");
		planningEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());

		planningRepository.save(planningEntity);
		logger.info("------ planningEntity Deleted Successfully ------");

		return true;
	}
	/*
	 * @Override public List<PlanningDto>
	 * getPlanningsByItemMachine(PlanningIncomingDto planningIncomingDto) { // TODO
	 * Auto-generated method stub
	 * 
	 * List<PlanningEntity> planningEntityList =
	 * planningRepository.getPlanningsByItemMachine(planningIncomingDto.getStationId
	 * (),planningIncomingDto.getItemId());
	 * 
	 * if (shiftEntityList == null) { throw
	 * BRSException.throwException("Shift Details does not exist."); }
	 * 
	 * return ShiftMapper.toShiftDtoList(shiftEntityList);
	 * 
	 * }
	 * 
	 * return null; }
	 */


	@Override
	public List<PlanningDto> getFilterPlannings(PlanningIncomingDto planningIncomingDto) {
		// TODO Auto-generated method stub
		
		UnitEntity unitEntity = new UnitEntity();
		unitEntity  = unitRepository.findById(planningIncomingDto.getUnitid()).get();
		if(unitEntity == null) {
			throw BRSException.throwException(EntityType.UNIT, ExceptionType.ENTITY_NOT_FOUND, planningIncomingDto.getUnitid());
		}
		
		WorkcenterEntity wsEntity = new WorkcenterEntity();
		
		logger.info("------ ws id -------"+planningIncomingDto.getWorkcenterid());
		
		if((planningIncomingDto.getWorkcenterid()!=null)&&(!planningIncomingDto.getWorkcenterid().equals("0")))
		wsEntity  = wsRepository.findById(planningIncomingDto.getWorkcenterid()).get();
		
		/*
		 * if(wsEntity == null) { throw
		 * BRSException.throwException(EntityType.WORKCENTER,
		 * ExceptionType.ENTITY_NOT_FOUND, planningIncomingDto.getWorkcenterid()); }
		 */
		List<PlanningEntity>  planningEntityList =planningRepository.getFilterPlannings(unitEntity.getId());
		
		return PlanningMapper.toOnlyPlanningDtoList(planningEntityList);
	}
}
