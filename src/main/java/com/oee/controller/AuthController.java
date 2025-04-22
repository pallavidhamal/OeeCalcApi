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

import com.oee.dto.AuthUserDto;
import com.oee.dto.incoming.LoginIncomingDto;
import com.oee.dto.incoming.SetNewPasswordIncomingDto;
import com.oee.dto.response.Response;
import com.oee.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/api/v1/auth"}, produces = APPLICATION_JSON_VALUE)
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

  	@Autowired
  	private AuthService authService;
  	
  	@SuppressWarnings("rawtypes")
 // 	@Operation(summary = "User Login")
 // 	@ApiResponse(responseCode = "201", description = "user login successfully", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthUserDto.class))})
  	@PostMapping( value = "/signin" , consumes = APPLICATION_JSON_VALUE)
  	public Response userSignIn( @RequestBody LoginIncomingDto loginRequest) {
  		
  		 AuthUserDto responseData;
  		 
  		 responseData = authService.authenticateUser(loginRequest);
  		 
  		 logger.info("Authentication successful!");
  		 
  		 return Response.ok().setPayload(responseData);
  	}
  	
    @PostMapping("/login")
    public String login(@RequestBody LoginIncomingDto user) {
        return authService.verify(user);
//        var u = userRepository.findByUserName(user.getUserName());
//        if(!Objects.isNull(u))
//            return "success";
//        return "failure";
    }
  	
//	@Operation(summary = "Reset Password")
//	@ApiResponse(responseCode = "200", description = "Reset Password", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = GradeDto.class))})
// step 1 - Send Email 
	@PostMapping( value = "/resetPassword/{email}" , consumes = APPLICATION_JSON_VALUE)
	public Response resetPassword( @RequestBody @PathVariable String email) {
		logger.info("***AuthController resetPassword***");
	//	logger.info(NEW_ORDER_LOG, createdUser.toString());
		return Response.ok().setPayload(authService.resetPassword(email));
		
	}
	
	
//	@Operation(summary = "check email to reset pass")
//	@ApiResponse(responseCode = "200", description = "check email to reset pass", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = GradeDto.class))})
//  step 2 - check Email 	
	@GetMapping( value = "/checkResetPassword/{email}" , consumes = APPLICATION_JSON_VALUE)
	public Response checkEmail( @RequestBody @PathVariable String email) {
		logger.info("***AuthController checkResetPassword***");
	//	logger.info(NEW_ORDER_LOG, createdUser.toString());
		return Response.ok().setPayload(authService.checkResetPasswordConditions(email));
		
	}
  	
//  step 2 - check Email 	
//	@Operation(summary = "Reset Password")
//	@ApiResponse(responseCode = "200", description = "Reset Password", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = GradeDto.class))})
	@PutMapping( value = "/setNewPassword" , consumes = APPLICATION_JSON_VALUE)
	public Response resetPassword( @RequestBody SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		logger.info("***AuthController setNewPassword***");
	//	logger.info(NEW_ORDER_LOG, createdUser.toString());
		return Response.ok().setPayload(authService.setNewPassword(setNewPasswordIncomingDto));
		
	}
	
	@PutMapping( value = "/changepassword" , consumes = APPLICATION_JSON_VALUE)
	public Response changePassword( @RequestBody SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		logger.info("***EmployeeInfoController changePassword***");
//		HashMap<String, Object> responseData = empInfoService.getEmpDetailsByEmpcode(id);
		return Response.ok().setPayload(authService.setOldCheckUpdateNewPassword(setNewPasswordIncomingDto));
		
	}
	
	@PutMapping( value = "/adminchangepassword" , consumes = APPLICATION_JSON_VALUE)
	public Response adminChangePassword( @RequestBody SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		logger.info("***EmployeeInfoController changePassword***");
//		HashMap<String, Object> responseData = empInfoService.getEmpDetailsByEmpcode(id);
		return Response.ok().setPayload(authService.setUpdateNewPassword(setNewPasswordIncomingDto));
		
	}
}