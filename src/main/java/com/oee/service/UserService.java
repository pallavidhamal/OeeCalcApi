package com.oee.service;

import java.util.List;

import com.oee.dto.UserDto;
import com.oee.dto.incoming.UserIncomingDto;
import com.oee.entity.UserInfoEntity;



public interface UserService {
	
	boolean addUser( UserIncomingDto userIncomingDto);
	boolean editUser( UserIncomingDto userIncomingDto);
	boolean deleteUser(String id);
	
	List<UserDto> findAllUsers();
	List<UserDto> findAllActiveUsers();
	UserDto getUserById(String id);
	UserDto getUserByEmailId(String id);
//	UserInfoEntity getUserEntityByEmailId(String id);
	UserInfoEntity getUserEntityByUsername(String id);
}
