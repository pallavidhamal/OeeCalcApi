
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
import com.oee.service.UomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/uom", produces = APPLICATION_JSON_VALUE)
public class UomController {

	@Autowired
	UomService uomService;

	private static final Logger logger = LoggerFactory.getLogger(UomController.class);

	@SuppressWarnings("rawtypes")

	@GetMapping(value = "/all")
	public Response getAllItems() {
		// logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
		return Response.ok().setPayload(uomService.getAllUoms());
	}

	/*
	 * @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE) public
	 * Response addItem(@RequestBody ItemIncomingDto itemIncomingDto) {
	 * logger.info("----- HtPartsController addHtPart----- ");
	 * 
	 * return Response.created().setPayload(itemService.addItem(itemIncomingDto));
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/edit", consumes = APPLICATION_JSON_VALUE) public
	 * Response editItem(@RequestBody ItemIncomingDto itemIncomingDto) {
	 * logger.info("----- HtPartsController editHtPart----- ");
	 * 
	 * return Response.ok().setPayload(itemService.editItem(itemIncomingDto));
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/delete/{htpartid}") public Response
	 * deleteHtPart(@PathVariable("htpartid") String itemid) {
	 * logger.info("----- HtPartsController deleteHtPart----- ");
	 * 
	 * return Response.ok().setPayload(itemService.deleteItem(itemid));
	 * 
	 * }
	 */
}
