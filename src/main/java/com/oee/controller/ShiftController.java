
package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.response.Response;
import com.oee.service.ShiftService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/shift", produces = APPLICATION_JSON_VALUE)
public class ShiftController {

	@Autowired
	ShiftService shiftService;

	private static final Logger logger = LoggerFactory.getLogger(ShiftController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/getAllShifts")
	public Response getAllShifts() {
		// logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
		return Response.ok().setPayload(shiftService.getAllShifts());
	}
	
	@GetMapping(value = "/get/{shiftid}")
	public Response getShiftById(@PathVariable("shiftid") String shiftid) {
		logger.info("----- StationController deleteHtPart----- ");

		return Response.ok().setPayload(shiftService.getShiftById(shiftid));
	}

	
	@GetMapping(value = "/getShiftByUnit/{unitid}")
	public Response getShiftByUnit(@PathVariable("unitid") String unitid) {
		logger.info("----- ShiftController getShiftByUnit----- ");

		return Response.ok().setPayload(shiftService.getShiftsByUnit(unitid));
	}
	
	
	/*
	 * @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE) public
	 * Response addShift(@RequestBody ShiftIncomingDto shiftIncomingDto) {
	 * logger.info("----- HtPartsController addHtPart----- ");
	 * 
	 * return
	 * Response.created().setPayload(shiftService.addShift(shiftIncomingDto));
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/edit", consumes = APPLICATION_JSON_VALUE) public
	 * Response editShift(@RequestBody ShiftIncomingDto shiftIncomingDto) {
	 * logger.info("----- editShift----- ");
	 * 
	 * return Response.ok().setPayload(shiftService.editShift(shiftIncomingDto));
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/delete/{shiftid}") public Response
	 * deleteShift(@PathVariable("shiftid") String shiftid) {
	 * logger.info("----- HtPartsController deleteShift----- ");
	 * 
	 * return Response.ok().setPayload(shiftService.deleteShift(shiftid));
	 * 
	 * }
	 */

	
	
	
}
