package com.oee.serviceimpl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.PlanningDto;
import com.oee.dto.ProductionDto;
import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.dto.incoming.ReportIncomingDto;
import com.oee.dto.mapper.PlanningMapper;
import com.oee.dto.mapper.ProductionMapper;
import com.oee.entity.OperatorEntity;
import com.oee.entity.PlanningEntity;
import com.oee.entity.ProductionEntity;
import com.oee.entity.ShiftEntity;
import com.oee.entity.StationEntity;
import com.oee.entity.StationTypeEntity;
import com.oee.entity.UnitEntity;
import com.oee.entity.UomEntity;
import com.oee.entity.WorkcenterEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.PlanningRepository;
import com.oee.repository.ProductionRepository;
import com.oee.repository.ReportRepository;
import com.oee.repository.StationRepository;
import com.oee.service.OperatorService;
import com.oee.service.PlanningService;
import com.oee.service.ProductionPlanningService;
import com.oee.service.ProductionService;
import com.oee.service.ReportService;
import com.oee.service.ShiftService;
import com.oee.service.StationService;
import com.oee.service.UnitService;
import com.oee.service.WorkcenterService;
import com.oee.util.AuthenticationService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	UnitService unitService;
	
	@Autowired
	WorkcenterService wsService;
	
	@Autowired
	StationService stationService;
	
	@Autowired
	ReportRepository reportRepository;
	
	
	@Override
	public List<Map<String, String>> getPlanOverview(ReportIncomingDto reportIncomingDto) {
		// TODO Auto-generated method stub
		
		
		UnitEntity unitEntity =new UnitEntity();
		if(!reportIncomingDto.getUnitid().equalsIgnoreCase("0")) {
		 unitEntity  = unitService.getActiveEntityById(reportIncomingDto.getUnitid());
		}
		
		WorkcenterEntity wsEntity=new WorkcenterEntity();
		if(!reportIncomingDto.getWorkcenterid().equalsIgnoreCase("0")) {
		 wsEntity = wsService.getActiveWorkcenterByID(reportIncomingDto.getWorkcenterid());
		}
		
		StationEntity  stationEntity =new StationEntity();
		if(!reportIncomingDto.getStationId().equalsIgnoreCase("0")) {
			stationEntity =stationService.getStationEntityByID(reportIncomingDto.getStationId());
		}
		
		List<Map<String, String>> reportList = reportRepository.getPlanOverview(unitEntity.getId(),wsEntity.getId(),stationEntity.getId(),reportIncomingDto.getFromdate(),reportIncomingDto.getTodate(),"N");
		
		
		return reportList;
		
		
		
		
		
		
	}


	@Override
	public List<Map<String, String>> getPlanVsActual(ReportIncomingDto reportIncomingDto) {
		// TODO Auto-generated method stub
		
		
		UnitEntity unitEntity =new UnitEntity();
		if(!reportIncomingDto.getUnitid().equalsIgnoreCase("0")) {
		 unitEntity  = unitService.getActiveEntityById(reportIncomingDto.getUnitid());
		}
		
		WorkcenterEntity wsEntity=new WorkcenterEntity();
		if(!reportIncomingDto.getWorkcenterid().equalsIgnoreCase("0")) {
		 wsEntity = wsService.getActiveWorkcenterByID(reportIncomingDto.getWorkcenterid());
		}
		
		StationEntity  stationEntity =new StationEntity();
		if(!reportIncomingDto.getStationId().equalsIgnoreCase("0")) {
			stationEntity =stationService.getStationEntityByID(reportIncomingDto.getStationId());
		}
		
		List<Map<String, String>> reportList = reportRepository.getPlanVsActual(unitEntity.getId(),wsEntity.getId(),stationEntity.getId(),reportIncomingDto.getFromdate(),reportIncomingDto.getTodate(),"N");
		
		
		return reportList;
		
		
		
		
		
		
		
		
		
		
	}

	
	
}
