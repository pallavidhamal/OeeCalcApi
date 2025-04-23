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

import com.oee.dto.incoming.StationIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.StationService;
import com.oee.service.StationTypeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/stationtype", produces = APPLICATION_JSON_VALUE)
public class StationTypeController {

	@Autowired
	StationTypeService stationtypeService;

	private static final Logger logger = LoggerFactory.getLogger(StationTypeController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllStationTypes() {
		return Response.ok().setPayload(stationtypeService.getAllStationTypes());
	}

	@GetMapping(value = "/allActive")
	public Response getAllActiveStationTypes() {
		return Response.ok().setPayload(stationtypeService.getAllActiveStationTypes());
	}

	@PutMapping(value = "/get/{htpartid}")
	public Response getStationTypeById(@PathVariable("htpartid") String stationtypeid) {
		logger.info("----- StationTypeController deleteHtPart----- ");

		return Response.ok().setPayload(stationtypeService.getStationTypeByID(stationtypeid));
	}


}