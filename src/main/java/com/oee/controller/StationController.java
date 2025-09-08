package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.incoming.StationIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.StationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/station", produces = APPLICATION_JSON_VALUE)
public class StationController {

	StationService stationService;

	private static final Logger logger = LoggerFactory.getLogger(StationController.class);

	public StationController (StationService stationService) {
		this.stationService = stationService;
	}
	
	
	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllStations() {
		return Response.ok().setPayload(stationService.getAllStations());
	}

	@GetMapping(value = "/allActive")
	public Response getAllActiveStations() {
		return Response.ok().setPayload(stationService.getAllActiveStations());
	}

	@GetMapping(value = "/get/{stationid}")
	public Response getStationById(@PathVariable("stationid") String stationid) {
		logger.info("----- StationController deleteHtPart----- ");

		return Response.ok().setPayload(stationService.getStationByID(stationid));
	}

	@PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
	public Response addStation(@RequestBody StationIncomingDto stationIncomingDto) {
		logger.info("----- StationController addHtPart----- ");

		return Response.created().setPayload(stationService.addStation(stationIncomingDto));
	}

	@PutMapping(value = "/edit", consumes = APPLICATION_JSON_VALUE)
	public Response editStation(@RequestBody StationIncomingDto stationIncomingDto) {
		logger.info("----- StationController editHtPart----- ");

		return Response.ok().setPayload(stationService.editStation(stationIncomingDto));
	}

	@PutMapping(value = "/delete/{stationid}")
	public Response deleteStation(@PathVariable("stationid") String stationid) {
		logger.info("----- StationController station----- ");

		return Response.ok().setPayload(stationService.deleteStation(stationid));
	}

	
	  @GetMapping(value = "/getStationByWc/{wcid}") 
	  public Response getStationByWc(@PathVariable("wcid") String wcid)
	  {
		return Response.ok().setPayload(stationService.getStationByWc(wcid));
	  }
		
	  @GetMapping(value = "/getStationByUnit/{unitid}") 
	  public Response getStationByUnit(@PathVariable("unitid") String unitid)
	  {
		return Response.ok().setPayload(stationService.getStationByUnit(unitid));
	  }
	  
	  @GetMapping(value = "/getStationByPlanId/{wcid}") 
	  public Response getStationByPlanId(@PathVariable("planid") String planid)
	  {
		return Response.ok().setPayload(stationService.getStationByPlanId(planid));
	  }
	
}
