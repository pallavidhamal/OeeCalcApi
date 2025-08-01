package com.oee.controller;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.service.ProductionPlanningService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/productionplanning"}, produces = APPLICATION_JSON_VALUE)
public class ProductionPlanningController {

private static final Logger logger = LoggerFactory.getLogger(ProductionPlanningController.class);
	
	ProductionPlanningService productionPlanningService;
	
	public ProductionPlanningController(ProductionPlanningService productionPlanningService) {
		this.productionPlanningService = productionPlanningService;
	}
}
