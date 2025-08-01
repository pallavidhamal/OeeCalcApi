package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.PlanningService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/planning", produces = APPLICATION_JSON_VALUE)
public class PlanningController {

	@Autowired
	PlanningService planningService;

	private static final Logger logger = LoggerFactory.getLogger(PlanningController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllPlannings() {
		return Response.ok().setPayload(planningService.getAllPlanningsWDetails());
	}

	@GetMapping(value = "/allplan")
	public Response getAllPlanningOnly() {
		return Response.ok().setPayload(planningService.getAllPlannings());
	}

	@PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
	public Response addPlanning(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController addHtPart----- ");

		return Response.created().setPayload(planningService.addPlanning(planningIncomingDto));
	}

	@PostMapping(value = "/filterPlanning", consumes = APPLICATION_JSON_VALUE)
	public Response getFilterPlanning(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController addHtPart----- ");

		return Response.ok().setPayload(planningService.getFilterPlannings(planningIncomingDto));
	}
	
	@PostMapping(value = "/planningExist", consumes = APPLICATION_JSON_VALUE)
	public Response getPlanningExist(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController addHtPart----- ");

		return Response.ok().setPayload(planningService.getFilterPlanningsExist(planningIncomingDto));
	}

	@GetMapping(value = "/get/{planId}")
	public Response getPlanningById(@PathVariable("planId") String planId) {
		logger.info("----- PlanningController getPlanningById----- ");
		return Response.ok().setPayload(planningService.getPlanningByID(planId));
	}
	
	@GetMapping(value = "/get/{planId}/{stationId}")
	public Response getPlanningByIdAndStation(@PathVariable("planId") String planId , @PathVariable("stationId") String stationId) {
		logger.info("----- PlanningController getPlanningById----- ");
		return Response.ok().setPayload(planningService.getPlanningByIDAndStation(planId , stationId));
	}

	
	@PostMapping(value = "/getPlanningByFilter" , consumes = APPLICATION_JSON_VALUE)
	public Response getPlanningByFilter(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController getPlanningById----- ");
		return Response.ok().setPayload(planningService.getFilterPlanEntity(planningIncomingDto));
	}
	
	
	@PostMapping(value = "/getPlanningByFilterWithGroupBy" , consumes = APPLICATION_JSON_VALUE)
	public Response getPlanningByFilterWithGroupBy(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController getPlanningById----- ");
		return Response.ok().setPayload(planningService.getFilterPlanEntityWithGroupBy(planningIncomingDto));
	}
	
	
	/*
	 * @GetMapping(value = "/allActive") public Response getAllActiveStations() {
	 * return Response.ok().setPayload(stationService.getAllActiveStations()); }
	 * 
	 */

	
	  @PutMapping(value = "/update", consumes = APPLICATION_JSON_VALUE) 
	  public Response editPlanning(@RequestBody PlanningIncomingDto planningIncomingDto) {
	  logger.info("----- PlanningController edit----- ");
	  
	  return
	  Response.ok().setPayload(planningService.editPlanning(planningIncomingDto));
	  
	  }
	 

	@PutMapping(value = "/delete/{planid}")
	public Response deletePlanning(@PathVariable("planid") String planid) {
		logger.info("----- PlanningController delete ----- ");

		return Response.ok().setPayload(planningService.deletePlanning(planid));

	}
	
	@PostMapping(value = "/getPlanOverview" , consumes = APPLICATION_JSON_VALUE)
	public Response getPlanOverview(@RequestBody PlanningIncomingDto planningIncomingDto) {
		logger.info("----- PlanningController getPlanOverview----- ");
		return Response.ok().setPayload(planningService.getPlanOverviewReport(planningIncomingDto));
	}
	

}
