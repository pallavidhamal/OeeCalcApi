
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

import com.oee.dto.incoming.WorkcenterIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.WorkcenterService;

@CrossOrigin(origins = "*", maxAge = 3600)
  
  @RestController
  
  @RequestMapping(value = "/api/v1/workcenter", produces = APPLICATION_JSON_VALUE)
  public class WorkcenterController {
  
  
  @Autowired WorkcenterService workcenterService;
  
  
  
  
  private static final Logger logger =
  LoggerFactory.getLogger(WorkcenterController.class);
  
  
  @SuppressWarnings("rawtypes")
  
  @GetMapping(value = "/getAll") 
  public Response getAll() {
  //logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
  return Response.ok().setPayload(workcenterService.getAllWorkcenters()); }
  
  @GetMapping(value = "/getAllActive") 
  public Response getAllActive() {
  //logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
  return Response.ok().setPayload(workcenterService.getAllActiveWorkcenters()); }
  
  

	@GetMapping( value = "/getWorkcenterByUnit/{unitid}" )
	public Response getWorkcenterByUnit(@PathVariable("unitid") String unitid) {
		logger.info("***UnitController get***");
		
		return Response.ok().setPayload(workcenterService.getWorkcenterByUnit(unitid));
	
	}
	
  
  
  
/*
 * @PostMapping( value = "/add" , consumes = APPLICATION_JSON_VALUE) public
 * Response addWorkcenter(@RequestBody WorkcenterIncomingDto workcenterIncomingDto) {
 * logger.info("----- HtPartsController addHtPart----- ");
 * 
 * return Response.created().setPayload(workcenterService.addWorkcenter(workcenterIncomingDto));
 * 
 * }
 * 
 * @PutMapping( value = "/edit" , consumes = APPLICATION_JSON_VALUE) public
 * Response editWorkcenter(@RequestBody WorkcenterIncomingDto workcenterIncomingDto) {
 * logger.info("----- HtPartsController editHtPart----- ");
 * 
 * return Response.ok().setPayload(workcenterService.editWorkcenter(workcenterIncomingDto));
 * 
 * }
 * 
 * @PutMapping( value = "/delete/{htpartid}" ) public Response
 * deleteHtPart(@PathVariable("htpartid") String workcenterid) {
 * logger.info("----- HtPartsController deleteHtPart----- ");
 * 
 * return Response.ok().setPayload(workcenterService.deleteWorkcenter(workcenterid));
 * 
 * }
 */
  
  }
