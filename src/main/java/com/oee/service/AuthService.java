package com.oee.service;
import com.oee.dto.AuthUserDto;
import com.oee.dto.incoming.LoginIncomingDto;
import com.oee.dto.incoming.SetNewPasswordIncomingDto;

public interface AuthService {
	
	
	public String verify(LoginIncomingDto user);
	AuthUserDto authenticateUser(LoginIncomingDto loginRequest);
	boolean resetPassword(String email);
	String checkResetPasswordConditions(String email);
	boolean setNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto);
	
	boolean setUpdateNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto);
	boolean setOldCheckUpdateNewPassword(SetNewPasswordIncomingDto setNewPasswordIncomingDto);
}