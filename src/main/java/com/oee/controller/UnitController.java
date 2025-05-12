package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.response.Response;
import com.oee.service.UnitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/unit"}, produces = APPLICATION_JSON_VALUE)
public class UnitController {

	UnitService unitService;
	
	private static final Logger logger = LoggerFactory.getLogger(UnitController.class);
	
	
	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}
	
	@GetMapping( value = "/getById/{id}" )
	public Response getById(@PathVariable("id") String id) {
		logger.info("***UnitController getById***");
		
		return Response.ok().setPayload(unitService.getById(id));
		
	}
	
	@GetMapping( value = "/get" )
	public Response get() {
		logger.info("***UnitController get***");
		
		return Response.ok().setPayload(unitService.get());
		
	}
	
	@GetMapping( value = "/getActive" )
	public Response getActive() {
		logger.info("***UnitController get***");
		
		return Response.ok().setPayload(unitService.getActive());
	
	}
	
	
	
	
	
	
}