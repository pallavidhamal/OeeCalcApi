package com.oee.serviceimpl;

import static com.oee.exception.ExceptionType.ALREADY_EXIST;

import java.util.List;

//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.oee.dto.UserDto;
import com.oee.dto.incoming.UserIncomingDto;
import com.oee.dto.mapper.UserMapper;
import com.oee.entity.RoleEntity;
import com.oee.entity.UserInfoEntity;
import com.oee.exception.BRSException;
import com.oee.exception.EntityType;
import com.oee.exception.ExceptionType;
import com.oee.repository.UserInfoRepository;
import com.oee.security.JwtUtils;
import com.oee.service.RoleService;
import com.oee.service.UserService;
import com.oee.util.AuthenticationService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final RoleService	 roleService;
	
	
	
    private final UserInfoRepository userInfoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    public UserServiceImpl(UserInfoRepository userInfoRepository, BCryptPasswordEncoder bCryptPasswordEncoder
    		, AuthenticationManager authenticationManager, JwtUtils jwtUtils , RoleService	 roleService) {
        this.userInfoRepository = userInfoRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.roleService = roleService;
    }
	
    
    
	

	@Override
	public boolean addUser( UserIncomingDto userIncomingDto) {
		// TODO Auto-generated method stub
		
		logger.info("********UserServiceImpl addUser********");
		
	/*	
		if (userIncomingDto.getUsername() == "" || userIncomingDto.getUsername() == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "User Name");	
		}
		
		if (userIncomingDto.getFirstname() == "") {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "First Name");
		}
		
		if (userIncomingDto.getLastname() == "") {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Last Name");		
		}
		
		if (userIncomingDto.getRole() == "") {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Role");		
		}
		
		if (userIncomingDto.getEmail() == "") {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Email ID");			
		}
		
//		if (userIncomingDto.getMobilenumber() == "") {
//			
//			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Mobile no");			
//		}
		
		if (userIncomingDto.getPassword() == "") {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Password");			
		}
		
		RoleEntity roleEntity = roleService.findRoleId(userIncomingDto.getRole());
		
		if (roleEntity == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userIncomingDto.getRole());			
		}
		UserInfoEntity emailIdDuplicateCheck = userInfoRepository.findByEmail(userIncomingDto.getEmail());
		
		if (emailIdDuplicateCheck != null) {
			
			logger.error("throw error that Email ID already exists = "+ userIncomingDto.getEmail());
			throw BRSException.throwException(EntityType.USER, ALREADY_EXIST, userIncomingDto.getEmail());
		}
		
		UserInfoEntity usernameDuplicateCheck = userInfoRepository.findByUsername(userIncomingDto.getUsername());
		
		if (usernameDuplicateCheck != null) {
			
			logger.error("throw error that User Name already exists = "+ userIncomingDto.getUsername());
			throw BRSException.throwException(EntityType.USER, ALREADY_EXIST, userIncomingDto.getUsername());
		}
		*/
		
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		
	//	userInfoEntity.setUsername(userIncomingDto.getUsername());
		userInfoEntity.setFirstname(userIncomingDto.getFirstname());
		userInfoEntity.setLastname(userIncomingDto.getLastname());
	//	userInfoEntity.setRole(roleEntity);
		userInfoEntity.setEmail(userIncomingDto.getEmail());
		userInfoEntity.setUsername(userIncomingDto.getUsername());
		userInfoEntity.setPassword(bCryptPasswordEncoder.encode(userIncomingDto.getPassword()));
		userInfoEntity.setMobilenumber(userIncomingDto.getMobilenumber());
		userInfoEntity.setIsdeleted(userIncomingDto.getStatus().equals("Active") ?  "N" : "Y");
		userInfoEntity.setStatus(userIncomingDto.getStatus());
		
//		userInfoEntity.setCreatedBy(AuthenticationService.getUserDetailsAfterLogin());
		
		userInfoRepository.save(userInfoEntity);
		
		logger.info("--- User Added Successfully ----");
		
		return true;
	}


    public String verify(UserInfoEntity user) {
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
	public boolean editUser( UserIncomingDto userIncomingDto) {
		// TODO Auto-generated method stub
		
		logger.info("********UserServiceImpl editUser********");
		
		if (userIncomingDto.getId() == "" || userIncomingDto.getId() == null) {
			
			throw BRSException.throwException("something went wrong");			
		}
		
		if (userIncomingDto.getUsername() == "" ) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "User Name");	
		}
		
		if (userIncomingDto.getFirstname() == "" || userIncomingDto.getFirstname() == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "First Name");	
		}
		
		if (userIncomingDto.getLastname() == "" || userIncomingDto.getLastname() == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Last Name");	
		}
		
		if (userIncomingDto.getRole() == "" || userIncomingDto.getRole()== null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Role");			
		}
		
		if (userIncomingDto.getEmail() == "" || userIncomingDto.getEmail() == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Email");		
		}
		
/*		if (userIncomingDto.getMobilenumber() == "" || userIncomingDto.getMobilenumber() == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.BLANK_VALUE, "Mobile no");		
		}
*/		
		RoleEntity roleEntity = roleService.findRoleId(userIncomingDto.getRole());
		
		if (roleEntity == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userIncomingDto.getRole());	
		}
		
		UserInfoEntity userInfoEntity = userInfoRepository.findById(userIncomingDto.getId()).get();
		
		if (userInfoEntity == null) {
			
			throw BRSException.throwException(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userIncomingDto.getId());	
		}
		
		//userInfoEntity.setUsername(userIncomingDto.getUsername());
		userInfoEntity.setFirstname(userIncomingDto.getFirstname());
		userInfoEntity.setLastname(userIncomingDto.getLastname());
		userInfoEntity.setRole(roleEntity);
		userInfoEntity.setEmail(userIncomingDto.getEmail());
		userInfoEntity.setMobilenumber(userIncomingDto.getMobilenumber());
		userInfoEntity.setIsdeleted(userIncomingDto.getStatus().equals("Active") ?  "N" : "Y");
		userInfoEntity.setStatus(userIncomingDto.getStatus());
		userInfoEntity.setModifiedBy(AuthenticationService.getUserDetailsAfterLogin());
			
		userInfoRepository.save(userInfoEntity);
		
		logger.info("--- User Updated Successfully ----");
		
		return true;
	}


	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl deleteUser********");
		
		UserInfoEntity userInfoEntity = userInfoRepository.findById(id).get();
		
		if (userInfoEntity == null) {
			
			throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND, id);		
		}
		
		if(userInfoEntity.getIsdeleted().equalsIgnoreCase("Y")) {
			
			userInfoEntity.setIsdeleted("N");
			userInfoEntity.setStatus("Active");
		}else {
			userInfoEntity.setIsdeleted("Y");
			userInfoEntity.setStatus("Inactive");
		}
		
		userInfoRepository.save(userInfoEntity);
		
		logger.info("--- User Deleted Successfully ----");
		
		return true;
		
	}


	@Override
	public List<UserDto> findAllUsers() {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl findAllUsers********");
		
		List<UserInfoEntity> userInfoEntities = userInfoRepository.findAll();
		
		if (userInfoEntities.size() == 0) {
			
			throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND);					
		}
		
		return UserMapper.toUserDtos(userInfoEntities);
	}
	
	@Override
	public List<UserDto> findAllActiveUsers() {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl findAllUsers********");
		
		List<UserInfoEntity> userInfoEntities = userInfoRepository.findByStatusAndIsdeleted("Active","N");
		
		if (userInfoEntities.size() == 0) {
			
			throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND);					
		}
		
		return UserMapper.toUserDtos(userInfoEntities);
	}


	@Override
	public UserDto getUserById(String id) {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl getUserById********");
		
	 UserInfoEntity userInfoEntity = userInfoRepository.getUserById(id);
	 
	 if (userInfoEntity == null) {
		 
		 throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND, id);		
	}
	 
		return UserMapper.toUserDto(userInfoEntity);
	}
	
	public UserDto getUserByEmailId(String id) {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl getUserById********");
		
	 UserInfoEntity userInfoEntity = userInfoRepository.findByEmail(id);
	 
	 if (userInfoEntity == null) {
		 
		 throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND, id);		
	}
	 
		return UserMapper.toUserDto(userInfoEntity);
	}
	
	public UserInfoEntity getUserEntityByEmailId(String id) {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl getUserById********");
		
	 UserInfoEntity userInfoEntity = userInfoRepository.findByEmail(id);
	 
	 if (userInfoEntity == null) {
		 
		 throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND, id);		
	}
	 
		return userInfoEntity;
	}
	
	public UserInfoEntity getUserEntityByUsername(String id) {
		// TODO Auto-generated method stub
		logger.info("********UserServiceImpl getUserById********");
		
	 UserInfoEntity userInfoEntity = userInfoRepository.findByUsername(id);
	 
	 if (userInfoEntity == null) {
		 
		 throw BRSException.throwException(EntityType.USER, com.oee.exception.ExceptionType.ENTITY_NOT_FOUND, id);		
	}
	 
		return userInfoEntity;
	}

}
