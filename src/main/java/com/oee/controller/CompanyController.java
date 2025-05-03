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
import com.oee.service.CompanyService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/company"}, produces = APPLICATION_JSON_VALUE)
public class CompanyController {

	CompanyService companyService;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping( value = "/getById/{id}" )
	public Response getById(@PathVariable("id") String id) {
		logger.info("***CompanyController getById***");
		
		return Response.ok().setPayload(companyService.getById(id));
		
	}
	
	@GetMapping( value = "/get" )
	public Response get() {
		logger.info("***CompanyController get***");
		
		return Response.ok().setPayload(companyService.get());
		
	}
	
	@GetMapping( value = "/getActive" )
	public Response getActive() {
		logger.info("***CompanyController get***");
		
		return Response.ok().setPayload(companyService.getActive());
		
	}
}
