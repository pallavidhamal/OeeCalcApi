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

import com.oee.dto.incoming.SetUpIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.SetUpService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/setup", produces = APPLICATION_JSON_VALUE)
public class SetUpController {

	@Autowired
	SetUpService setUpService;

	private static final Logger logger = LoggerFactory.getLogger(SetUpController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllSetups() {
		return Response.ok().setPayload(setUpService.getAllSetUps());
	}

	
	 @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
	 public  Response addSetUp(@RequestBody SetUpIncomingDto setUpIncomingDto) {
	  logger.info("----- StationController addHtPart----- ");
	  
	  return   Response.created().setPayload(setUpService.addSetUp(setUpIncomingDto));
	  }
	
	 
	 @GetMapping(value = "/get/{setupId}") 
	 public Response  getSetUpById(@PathVariable("setupId") String setupId)
	 {
	  logger.info("-----  getSetUpById----- ");
	  return Response.ok().setPayload(setUpService.getSetUpByID(setupId)); 
	  }
	  
	
		
		/*
		 * @GetMapping(value = "/allActive") public Response getAllActiveStations() {
		 * return Response.ok().setPayload(stationService.getAllActiveStations()); }
		 * 
		 * 
		 * 
		 * 
		 * @PutMapping(value = "/edit", consumes = APPLICATION_JSON_VALUE) public
		 * Response editStation(@RequestBody StationIncomingDto stationIncomingDto) {
		 * logger.info("----- StationController editHtPart----- ");
		 * 
		 * return
		 * Response.ok().setPayload(stationService.editStation(stationIncomingDto)); }
		 * 
		 * @PutMapping(value = "/delete/{htpartid}") public Response
		 * deleteStation(@PathVariable("htpartid") String stationid) {
		 * logger.info("----- StationController deleteHtPart----- ");
		 * 
		 * return Response.ok().setPayload(stationService.deleteStation(stationid)); }
		 */
		 
}
