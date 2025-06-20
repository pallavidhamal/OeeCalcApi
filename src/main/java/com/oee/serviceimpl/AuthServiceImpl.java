package com.oee.serviceimpl;
import com.oee.dto.incoming.LoginIncomingDto;
import com.oee.dto.incoming.SetNewPasswordIncomingDto;
import com.oee.dto.mapper.AuthUserMapper;
import com.oee.dto.AuthUserDto;
import com.oee.entity.RefreshToken;
import com.oee.entity.UserInfoEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.UserInfoRepository;
import com.oee.security.JwtUtils;
import com.oee.service.AuthService;
import com.oee.service.RefreshTokenService;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class AuthServiceImpl implements AuthService{

	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	
	AuthUserMapper authUserMapper=null;
	
	Base64.Encoder baseEncoder = Base64.getEncoder();
	
	Base64.Decoder baseDecoder = Base64.getDecoder();
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	JwtUtils jwtUtils;
	
//	@Autowired
//	EmailService emailService;
	
	@Autowired
	RefreshTokenService refreshTokenService;
		
	@Autowired
	UserInfoRepository empInfoRepository ;
	
	@Autowired 
	AuthenticationManager authenticationManager;

	
	
    public String verify(LoginIncomingDto user) {
        Authentication authenticate
                = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                )
        );

        //var u = userRepository.findByUserName(user.getUserName());
        if(authenticate.isAuthenticated())
            return jwtUtils.generateTokenFromUsername(user.getUsername());
        return "failure";
    }
	
	@Override
	public AuthUserDto authenticateUser(LoginIncomingDto loginRequest) {
		
		logger.info("****AuthServiceImpl authenticateUser****");

		authUserMapper=new AuthUserMapper();
		
		AuthUserDto response=new AuthUserDto();
		
		if(loginRequest.getUsername().equalsIgnoreCase("")) { 
			throw BRSException.throwException("Error: Login Id cannot be empty!"); 
		}
		if(loginRequest.getPassword().equalsIgnoreCase("")) { 
			throw BRSException.throwException("Error: Password cannot be empty!"); 
		}
		
		 UserInfoEntity masterEntity =  empInfoRepository.findByUsername(loginRequest.getUsername());
		  
		 if(masterEntity == null) {
			 
			 throw BRSException.throwException("Invalid User"); 
		 }
		 
			/*
			 * if(masterEntity.getVerified().equalsIgnoreCase("N")) {
			 * 
			 * throw BRSException.throwException("Error: The Username is not Verified!"); }
			 */
		 
		 
		 if(masterEntity.getStatus().equalsIgnoreCase("Inactive")){
			 throw BRSException.throwException("Error: User status is inactive.");
		 }
		 
		
	//	 String encodedPassword = encoder.encode(loginRequest.getPassword());
		
	//	 System.out.println("-----encodedPassword--------"+encodedPassword);
	//	 System.out.println("-----masterEntity.getPassword()--------"+masterEntity.getPassword());
		 
		 boolean isPasswordMatch = encoder.matches(loginRequest.getPassword(), masterEntity.getPassword());
			System.out.println("Password : " + loginRequest.getPassword() + "   isPasswordMatch    : " + isPasswordMatch);
			
			 if(!isPasswordMatch) {
				 
				 throw BRSException.throwException("Invalid User"); 
			 }
		
		 Authentication authentication = authenticationManager.authenticate( 
				  new UsernamePasswordAuthenticationToken(
						  loginRequest.getUsername(),loginRequest.getPassword()));
		 
		 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
			
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
		
		
		masterEntity.setFirstloginstatus("Y");
		
		
		empInfoRepository.save(masterEntity);		
		//
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
			if(masterEntity!=null) {
				response=authUserMapper.toUserLoginDto(masterEntity, jwt,refreshToken.getToken());
			}
		  
		return response ;
	}

	@Override
	public boolean resetPassword(String email) {
		
		logger.info("*****AuthServiceImpl resetPassword*****"+ email);
		
		UserInfoEntity emp = empInfoRepository.findByEmail(email);
		
		if(emp == null) {
			logger.info("Error: Email Id is not registered. Email = "+ email);
			throw BRSException.throwException("Error: The email address provided is not registered to your organization!");
		}
		logger.info("Email existance check complete.");
		String encodeEmail = baseEncoder.encodeToString(email.getBytes(StandardCharsets.UTF_8)) ;
		
		
//		emailService.sendResetPasswordMail(encodeEmail,email);
		
		emp.setReset_password("Y");
		emp.setResetPassInstance(Instant.now());
		empInfoRepository.save(emp);
		
		logger.info("Reset password mail sent.");
		return true;
	}
	
	@Override
	public String checkResetPasswordConditions(String email) {
		
		logger.info("*****AuthServiceImpl checkResetPasswordConditions*****"+ email);
		
		String emailId = new String (baseDecoder.decode(email));
		
		UserInfoEntity emp = empInfoRepository.findByEmail(emailId);
		
		if(emp == null) {
			logger.info("Email id is not registered. email = "+ email);
			throw BRSException.throwException("Error: The email address provided is not registered to your organization!");
		}
		logger.info("Email id check complete.");
		
		if(emp.getReset_password().equalsIgnoreCase("N")) {
			logger.info("Reset flag has wrong value = "+ emp.getReset_password());
			throw BRSException.throwException("Error: Reset flag has wrong value for record with email="+email+".");
		}
		logger.info("Reset flag check complete.");
		
		Instant resetInstance = emp.getResetPassInstance();
		
		Instant value = resetInstance.plus(1, ChronoUnit.HOURS);
		logger.info(resetInstance+"-----"+ value+"----"+ Instant.now()+"-----  "+Instant.now().compareTo(value));
		//  now.compareto(value) = 1 then now is greater than value
		// now.compareto(value) = -1 then now is less than value
		if(Instant.now().compareTo(value) < 0) {
			logger.info("Send true");
		}if(Instant.now().compareTo(value) > 0 ) {
			logger.info("Reset token has expired.");
			throw BRSException.throwException("Error: Reset token expired. Please start the reset Password process again.");
		}
		logger.info("Password check completed.");

		return emp.getUsername();
	}
	
	@Override
	public boolean setNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		
		logger.info("*****AuthServiceImpl setNewPassword*****"+ setNewPasswordIncomingDto.getConfirmpassword());
		
		String emailId = new String (baseDecoder.decode(setNewPasswordIncomingDto.getUsername()));
		
		UserInfoEntity emp = empInfoRepository.findByEmail(emailId);
		
		if(emp == null) {
			logger.info("Error: The email address provided is not registered.");
			throw BRSException.throwException("Error: The email address provided is not registered to the organization!");
		}
		
		if(!setNewPasswordIncomingDto.getPassword().equalsIgnoreCase(setNewPasswordIncomingDto.getConfirmpassword())) {
			logger.info("Error: Passwords Do not match.");
			throw BRSException.throwException("Error: Passwords do not match!");
		}
		
		emp.setReset_password("N");
		emp.setPassword(encoder.encode(setNewPasswordIncomingDto.getPassword()));
//		emp.setReset_password_count(emp.getReset_password_count() + 1);
		empInfoRepository.save(emp);
		logger.info("Password has been reset.");
		return true;
	}
	
	@Override
	public boolean setOldCheckUpdateNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		
		logger.info("*****AuthServiceImpl setNewPassword*****"+ setNewPasswordIncomingDto.getConfirmpassword());
		
		String username = setNewPasswordIncomingDto.getUsername();
		
		Optional<UserInfoEntity> empOptional = empInfoRepository.findById(username);
		
		UserInfoEntity emp = empOptional.get();
		
		if(emp == null) {
			logger.info("Error: The email address provided is not registered.");
			throw BRSException.throwException("Error: The email address provided is not registered to the organization!");
		}
		
		/*if(!setNewPasswordIncomingDto.getPassword().equalsIgnoreCase(setNewPasswordIncomingDto.getConfirmpassword())) {
			logger.info("Error: Passwords Do not match.");
			throw BRSException.throwException("Error: Passwords do not match!");
		}*/
		System.out.println("Password : " + setNewPasswordIncomingDto.getPassword() );
		 boolean isPasswordMatch = encoder.matches(setNewPasswordIncomingDto.getPassword(), emp.getPassword());
			System.out.println("Password : " + emp.getPassword() + "   isPasswordMatch    : " + isPasswordMatch);
		
		if(!isPasswordMatch) {
			throw BRSException.throwException("Error: old password does not match with the old password inside the database.");
		}
			 
			
		emp.setReset_password("N");
		emp.setPassword(encoder.encode(setNewPasswordIncomingDto.getConfirmpassword()));
//		emp.setReset_password_count(emp.getReset_password_count() + 1);
		empInfoRepository.save(emp);
		logger.info("Password has been reset.");
		return true;
	}
	
	@Override
	public boolean setUpdateNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto) {
		
		logger.info("*****AuthServiceImpl setNewPassword*****"+ setNewPasswordIncomingDto.getConfirmpassword());
		
		String username = setNewPasswordIncomingDto.getUsername();
		
		Optional<UserInfoEntity> empOptional = empInfoRepository.findById(username);
		
		UserInfoEntity emp = empOptional.get();
		
		if(emp == null) {
			logger.info("Error: The email address provided is not registered.");
			throw BRSException.throwException("Error: The email address provided is not registered to the organization!");
		}
		
		/*if(!setNewPasswordIncomingDto.getPassword().equalsIgnoreCase(setNewPasswordIncomingDto.getConfirmpassword())) {
			logger.info("Error: Passwords Do not match.");
			throw BRSException.throwException("Error: Passwords do not match!");
		}*/
		
		emp.setReset_password("N");
		emp.setPassword(encoder.encode(setNewPasswordIncomingDto.getConfirmpassword()));
//		emp.setReset_password_count(emp.getReset_password_count() + 1);
		empInfoRepository.save(emp);
		logger.info("Password has been reset.");
		return true;
	}

}
