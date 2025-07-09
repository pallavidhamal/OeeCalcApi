package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.incoming.PlanningIncomingDto;
import com.oee.dto.incoming.ProductionIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.ProductionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/production"}, produces = APPLICATION_JSON_VALUE)
public class ProductionController {

	private static final Logger logger = LoggerFactory.getLogger(ProductionController.class);
	
	ProductionService productionService;
	
	public ProductionController(ProductionService productionService) {
		this.productionService = productionService;
	}
	
	
	  @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE) 
	  public  Response addProduction(@RequestBody ProductionIncomingDto productionIncomingDto)
	  {
	  logger.info("----- PlanningController addHtPart----- ");
	  
	  return 	  Response.created().setPayload(productionService.addProduction(productionIncomingDto));
	  }
	  
	  
	  @GetMapping(value = "/allproduction")
		public Response getAllProduction() {
			return Response.ok().setPayload(productionService.getAllProduction());
		}
	  
	  
	  @GetMapping(value = "/get/{prodId}")
		public Response getProductionById(@PathVariable("prodId") String prodId) {
			logger.info("----- ProdController getProdById----- ");
			return Response.ok().setPayload(productionService.getProductionByID(prodId));
		}
	 
	
}
