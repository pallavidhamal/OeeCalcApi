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
import com.oee.service.PlanningShiftWorkService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/planning", produces = APPLICATION_JSON_VALUE)
public class PlanningShiftWorkController {

	@Autowired
	PlanningShiftWorkService planningShiftWorkService;

	private static final Logger logger = LoggerFactory.getLogger(PlanningShiftWorkController.class);

	@SuppressWarnings("rawtypes")

	@PutMapping(value = "/delete/{id}")
	public Response deletePlanning(@PathVariable("id") String id) {
		logger.info("----- PlanningController delete ----- ");

		return Response.ok().setPayload(planningShiftWorkService.deletePlanningShiftWork(id));
	}
}
