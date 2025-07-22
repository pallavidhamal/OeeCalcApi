package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.incoming.ReportIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.ReportService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/report"}, produces = APPLICATION_JSON_VALUE)
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	ReportService reportService;
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	  @PostMapping(value = "/getPlanOverview", consumes = APPLICATION_JSON_VALUE) 
	  public  Response getPlanOverview(@RequestBody ReportIncomingDto  reportIncomingDto) 
	  {
	  logger.info("----- getPlanOverview----- ");
	  return Response.created().setPayload(reportService.getPlanOverview(reportIncomingDto));
	  
	  }
	  
}
