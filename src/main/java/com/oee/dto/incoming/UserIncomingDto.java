package com.oee.dto.incoming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserIncomingDto {
	
	private String id;
	private String username;
	private String firstname;
	private String lastname;
	private String role;
	private String email;
	private String mobilenumber;
	private String password;
	private String status;

}
