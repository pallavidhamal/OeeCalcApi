package com.oee.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oee.dto.RoleDto;
import com.oee.entity.RoleEntity;

public class RoleMapper {
	
	public static RoleDto toRoleDto(RoleEntity roleEntity) {
		return new RoleDto()
				.setId(roleEntity.getId())
				.setName(roleEntity.getName())
				.setStatus(roleEntity.getStatus())
				.setIsdeleted(roleEntity.getIsdeleted().equals("Y") ?  "Active" : "Inactive" )
				.setNamecode(roleEntity.getNamecode());
		
	}
	
	public static List<RoleDto> toRoleDtos(List<RoleEntity> roleEntities){
		
		List<RoleDto> roleDtos = new ArrayList<RoleDto>();
		for(RoleEntity roleEntity : roleEntities) {
			
			roleDtos.add((RoleDto) toRoleDto(roleEntity)); 
		}
		return roleDtos;
	}

}
