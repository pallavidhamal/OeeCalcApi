package com.oee.serviceimpl;

import static com.oee.exception.ExceptionType.ALREADY_EXIST;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oee.dto.RoleDto;
import com.oee.dto.incoming.RoleIncomingDto;
import com.oee.dto.mapper.RoleMapper;
import com.oee.entity.RoleEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.RoleRepository;
import com.oee.service.RoleService;



@Service
public class RoleServiceImpl implements RoleService{
	
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	RoleRepository	roleRepository;
	
	
	@Override
	public boolean addRole( RoleIncomingDto roleIncomingDto) {
		// TODO Auto-generated method stub
		
		logger.info("********RoleServiceImpl addRole********");
		
		if (roleIncomingDto.getName() == "") { 
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.BLANK_VALUE, "Name");	
		}
		
		if (roleIncomingDto.getNamecode() == "") {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.BLANK_VALUE, "Name Code");	
			
		}
		
		/*
		 * if (roleIncomingDto.getStatus() == "") {
		 * 
		 * throw BRSException.throwException(EntityType.ROLE,
		 * ExceptionType.ENTITY_NOT_FOUND);
		 * 
		 * }
		 */
		
		RoleEntity roleCodeDuplicateCheck = roleRepository.findByName(roleIncomingDto.getNamecode());
		
		if (roleCodeDuplicateCheck != null) {
			
			logger.error("throw error that user already exists for NameCode = "+ roleIncomingDto.getNamecode());
			
			throw BRSException.throwException(EntityType.ROLE, ALREADY_EXIST, roleIncomingDto.getNamecode());
			 
		}
		RoleEntity usernameDuplicateCheck = roleRepository.findByName(roleIncomingDto.getName());
		
		if (usernameDuplicateCheck != null) {
			
			logger.error("throw error that user already exists for RoleName = "+ roleIncomingDto.getName());
			throw BRSException.throwException(EntityType.ROLE, ALREADY_EXIST, roleIncomingDto.getName());
		}
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName(roleIncomingDto.getName());
		roleEntity.setNameCode(roleIncomingDto.getNamecode());
		roleEntity.setStatus(roleIncomingDto.getStatus());
		roleEntity.setIsdeleted("N");		
		
		roleRepository.save(roleEntity);
		
		logger.info("--- Role Added Successfully ----");
		
		return true;
	}


	@Override
	public RoleEntity findRoleNameByCode(String code) {
		// TODO Auto-generated method stub
		logger.info("-------- RoleServiceImpl findRoleNameByCode ------");
		
		RoleEntity roleEntity = roleRepository.findByNameCode(code);
		
		if (roleEntity == null) {			
			throw BRSException.throwException("Error : No Record Found");			
		}
		
		return roleEntity;
	}


	@Override
	public RoleEntity findRoleId(String id) {
		// TODO Auto-generated method stub
		
		logger.info("-------- RoleServiceImpl findRoleId ------");
		
		RoleEntity roleEntity = roleRepository.findById(id).get();
		
		if (roleEntity == null) {			
			throw BRSException.throwException("Error : No Record Found");			
		}
		
		return roleEntity;
	}


	@Override
	public boolean editRole( RoleIncomingDto roleIncomingDto) {
		// TODO Auto-generated method stub
		
		logger.info("-------- RoleServiceImpl editRoleInfoDetails ------");
		
		if (roleIncomingDto.getId() == "" || roleIncomingDto.getId() == null) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.BLANK_VALUE, "ID");	
			
		}
		
		if (roleIncomingDto.getName() == "" || roleIncomingDto.getName() == null) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.BLANK_VALUE, "Name");	
			
		}
		
		if (roleIncomingDto.getNamecode() == "" || roleIncomingDto.getNamecode() == null) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.BLANK_VALUE, "Name Code");	
			
		}
		
		RoleEntity roleEntity = roleRepository.findById(roleIncomingDto.getId()).get();
		
		if (roleEntity ==  null) {
			
			throw BRSException.throwException(EntityType.ROLE,ExceptionType.ENTITY_NOT_FOUND, roleIncomingDto.getId());			
		}
		
		
		List<RoleEntity> roleEntitiesName = roleRepository.findByIdNotAndName(roleIncomingDto.getId(),roleIncomingDto.getName());
		
		if (roleEntitiesName.size() !=  0) {
			
			throw BRSException.throwException(EntityType.ROLE,ExceptionType.ALREADY_EXIST, roleIncomingDto.getName());			
		}
		
		List<RoleEntity> roleEntitiesCode = roleRepository.findByIdNotAndNameCode(roleIncomingDto.getId(),roleIncomingDto.getNamecode());
		
		if (roleEntitiesCode.size() !=  0) {
			
			throw BRSException.throwException(EntityType.ROLE,ExceptionType.ALREADY_EXIST, roleIncomingDto.getNamecode());			
		}
		
		
		
		roleEntity.setName(roleIncomingDto.getName());
		roleEntity.setNameCode(roleIncomingDto.getNamecode());
		roleEntity.setIsdeleted("N");
		roleEntity.setStatus(roleIncomingDto.getStatus());
		roleRepository.save(roleEntity);
		
		logger.info("--- Record Updated Successfully ----");
		
		return true;
	}


	@Override
	public boolean deleteRole(String id) {
		// TODO Auto-generated method stub
		
		logger.info("-------- RoleServiceImpl deleteRoleById ------");
		
		RoleEntity roleEntity = roleRepository.findById(id).get();
		
		if (roleEntity == null) {			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND, id);			
		}
		
		if(roleEntity.getIsdeleted().equalsIgnoreCase("Y")) {
		
			roleEntity.setIsdeleted("N");
			roleEntity.setStatus("Active");
		}else {
			roleEntity.setIsdeleted("Y");
			roleEntity.setStatus("Inactive");
		}
		
		roleRepository.save(roleEntity);
		
		logger.info("--- Record Deleted Successfully ----");
		
		return true;
	}


	@Override
	public List<RoleDto> findAllRoles() {
		// TODO Auto-generated method stub
		logger.info("-------- RoleServiceImpl getAllRoles ------");
		
		List<RoleEntity> roleEntities = roleRepository.findAll();
		
		if (roleEntities.size() == 0) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND);		
		}
		
		return RoleMapper.toRoleDtos(roleEntities);
	}


	@Override
	public List<RoleDto> findActiveRoles() {
		// TODO Auto-generated method stub
		logger.info("-------- RoleServiceImpl getAllActiveRoles ------");
		
		List<RoleEntity> roleEntities = roleRepository.findByStatusAndIsdeleted("Active","N");
		
		if (roleEntities.size() == 0) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND);		
		}
				
		return RoleMapper.toRoleDtos(roleEntities);
	}


	@Override
	public RoleDto getRoleById(String id) {
		// TODO Auto-generated method stub
		logger.info("-------- RoleServiceImpl getRoledetailsById ------");
		
		RoleEntity roleEntity = roleRepository.getRoleById(id);
		
		if (roleEntity == null) {
			
			throw BRSException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND, id);	
		}
		
		return RoleMapper.toRoleDto(roleEntity);
	}

}
