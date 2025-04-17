package com.oee.service;

import java.util.List;


import com.oee.dto.incoming.RoleIncomingDto;
import com.oee.dto.RoleDto;
import com.oee.entity.RoleEntity;

public interface RoleService {
	
	
	  RoleEntity findRoleNameByCode(String code);  
	  RoleEntity findRoleId(String id);
	 
	  boolean addRole( RoleIncomingDto roleIncomingDto);
	  boolean editRole( RoleIncomingDto roleIncomingDto);
	  boolean deleteRole(String id);
	  
	  List<RoleDto> findAllRoles();
	  List<RoleDto> findActiveRoles();
	  RoleDto getRoleById(String id);
	  
	  
	  
	  

}
