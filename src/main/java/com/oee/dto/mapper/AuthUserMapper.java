package com.oee.dto.mapper;
import java.util.ArrayList;
import java.util.List;

import com.oee.dto.AuthUserDto;
import com.oee.entity.UserInfoEntity;
import com.oee.entity.WorkcenterEntity;

public class AuthUserMapper {

	
	public static AuthUserDto toUserLoginDto(UserInfoEntity userInfo,String jwt,String refreshToken) {
		 		
        return new AuthUserDto()
        		.setUserId(userInfo.getId())
        		.setUsername(userInfo.getUsername())
        		.setRole(userInfo.getRole().getNamecode())
        		.setRolename(userInfo.getRole().getName())
        		.setRefreshToken(refreshToken)
        		.setTokenType("Bearer")
        		.setAccessToken(jwt)
        		.setMobileno(userInfo.getMobilenumber())
        		.setStatus(userInfo.getStatus())
        		.setEmail(userInfo.getEmail())
        		.setLogincount(userInfo.getLogincount())
        		.setUnitDto( userInfo.getUnitentity() == null ? null : UnitMapper.toUnitDto(userInfo.getUnitentity()) )
        		.setWorkcenterDto(userInfo.getWorkcenterentity() == null ? null : WorkcenterMapper.toWorkcenterDto(userInfo.getWorkcenterentity()));
        		
    }	
	
	public static List<AuthUserDto> toUserLoginDto(List<UserInfoEntity> userInfoEntities) {
		// TODO Auto-generated method stub
		
		List<AuthUserDto> authUserDtos= new ArrayList<AuthUserDto>();
		for(UserInfoEntity userinfoEntity :userInfoEntities)
		{
			authUserDtos.add((AuthUserDto) toUserLoginDto(userinfoEntity, null, null));			
		}
				
		return authUserDtos;
	}   
	
	public static AuthUserDto toUserLoginDto(UserInfoEntity userInfo) {
 		
        return new AuthUserDto()
        		.setUserId(userInfo.getId())
        		.setUsername(userInfo.getUsername())
        		.setRole(userInfo.getRole().getNamecode())  	
        		.setMobileno(userInfo.getMobilenumber())
        		.setEmail(userInfo.getEmail())
        		.setStatus(userInfo.getStatus())
        		.setRolename(userInfo.getRole().getName())
        		.setLogincount(userInfo.getLogincount())
        		.setUnitDto( userInfo.getUnitentity() == null ? null : UnitMapper.toUnitDto(userInfo.getUnitentity()) )
        		.setWorkcenterDto(userInfo.getWorkcenterentity() == null ? null : WorkcenterMapper.toWorkcenterDto(userInfo.getWorkcenterentity()));
        		
    }

}