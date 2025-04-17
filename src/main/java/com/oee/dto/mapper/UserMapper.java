package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;


import com.oee.dto.UserDto;
import com.oee.entity.UserInfoEntity;

public class UserMapper {
	
	public static UserDto toUserDto(UserInfoEntity userInfoEntity) {
		return new UserDto()
				.setUserID(userInfoEntity.getId())
				.setUsername(userInfoEntity.getUsername())
				.setFirstname(userInfoEntity.getFirstname())
				.setLastname(userInfoEntity.getLastname())
				.setRole(userInfoEntity.getRole().getName())
				.setEmail(userInfoEntity.getEmail())
				.setStatus(userInfoEntity.getStatus())
				.setIsdeleted(userInfoEntity.getIsdeleted().equals("Y") ?  "Active" : "Inactive")
				.setMobilenumber(userInfoEntity.getMobilenumber());
				
	}
	
	public static List<UserDto> toUserDtos(List<UserInfoEntity> userInfoEntities){
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(UserInfoEntity userInfoEntity : userInfoEntities) {
			
			userDtos.add((UserDto) toUserDto(userInfoEntity)); 
		}
		return userDtos;
	}

}
