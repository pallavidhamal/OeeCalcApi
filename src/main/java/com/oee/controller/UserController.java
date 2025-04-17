package com.oee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oee.dto.incoming.UserIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.UserService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/user"}, produces = APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping( value = "/addUser" , consumes = APPLICATION_JSON_VALUE)
	public Response addUser( @RequestBody UserIncomingDto userIncomingDto) {
		logger.info("***UserController addUser***");

		return Response.created().setPayload(userService.addUser(userIncomingDto));
		
	}
	
	@PostMapping( value = "/editUser" , consumes = APPLICATION_JSON_VALUE)
	public Response editUser( @RequestBody UserIncomingDto userIncomingDto) {
		logger.info("***UserController editUser***");
		
		return Response.ok().setPayload(userService.editUser(userIncomingDto));
		
	}
	
	@GetMapping( value = "/deleteUser/{id}" )
	public Response deleteUser(@PathVariable("id") String id) {
		logger.info("***UserController deleteUser***");

		return Response.ok().setPayload(userService.deleteUser(id));
		
	}
	
	@GetMapping( value = "/allUsers" )
	public Response findAllUsers() {		
		logger.info("***UserController findALLUsers***");

		return Response.ok().setPayload(userService.findAllUsers());	
	}
	
	@GetMapping( value = "/getUserById/{id}" )
	public Response getRoleById(@PathVariable("id") String id) {
		logger.info("***UserController UserById***");
		
		return Response.ok().setPayload(userService.getUserById(id));
		
	}
	
	@GetMapping( value = "/getUserByEmailId/{id}" )
	public Response getByEmailId(@PathVariable("id") String id) {
		logger.info("***UserController getByEmailId***");
		
		return Response.ok().setPayload(userService.getUserByEmailId(id));
		
	}
	

}
