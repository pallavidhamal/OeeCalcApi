/*
 * package com.oee.controller;
 * 
 * import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.oee.dto.incoming.UnitIncomingDto; import
 * com.oee.dto.response.Response; import com.oee.service.UnitService; import
 * com.oee.service.UnitService;
 * 
 * @CrossOrigin(origins = "*", maxAge = 3600)
 * 
 * @RestController
 * 
 * @RequestMapping(value = "/api/v1/unit", produces = APPLICATION_JSON_VALUE)
 * public class UnitController {
 * 
 * 
 * @Autowired UnitService unitService ;
 * 
 * 
 * 
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(UnitController.class);
 * 
 * 
 * @SuppressWarnings("rawtypes")
 * 
 * @GetMapping(value = "/getAllUnits") public Response getAllUnits() {
 * //logger.info("----- FittingTypeController getAllFittingTypeDetails ----- ");
 * return Response.ok().setPayload(unitService.getAllUnits()); }
 * 
 * sd
 * 
 * @PostMapping( value = "/add" , consumes = APPLICATION_JSON_VALUE) public
 * Response addUnit(@RequestBody UnitIncomingDto unitIncomingDto) {
 * logger.info("----- HtPartsController addHtPart----- ");
 * 
 * return Response.created().setPayload(unitService.addUnit(unitIncomingDto));
 * 
 * }
 * 
 * @PutMapping( value = "/edit" , consumes = APPLICATION_JSON_VALUE) public
 * Response editUnit(@RequestBody UnitIncomingDto unitIncomingDto) {
 * logger.info("----- HtPartsController editHtPart----- ");
 * 
 * return Response.ok().setPayload(unitService.editUnit(unitIncomingDto));
 * 
 * }
 * 
 * @PutMapping( value = "/delete/{htpartid}" ) public Response
 * deleteHtPart(@PathVariable("htpartid") String unitid) {
 * logger.info("----- HtPartsController deleteHtPart----- ");
 * 
 * return Response.ok().setPayload(unitService.deleteUnit(unitid));
 * 
 * }
 * 
 * 
 * }
 */