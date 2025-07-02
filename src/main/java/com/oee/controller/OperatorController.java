
package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.response.Response;
import com.oee.service.OperatorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/operator", produces = APPLICATION_JSON_VALUE)
public class OperatorController {

	@Autowired
	OperatorService operatorService;

	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllOperator() {
		// logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
		return Response.ok().setPayload(operatorService.getAllOperators());
	}
	@GetMapping(value = "allActive")
	public Response getAllActiveOperator() {
		// logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
		return Response.ok().setPayload(operatorService.getAllActiveOperators());
	}
	
}
