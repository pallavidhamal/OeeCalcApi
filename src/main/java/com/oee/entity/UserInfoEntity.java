package com.oee.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.oee.entity.id.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "emp_info")
@Setter
@Getter
public class UserInfoEntity extends BaseEntity{
	

	private String mobilenumber;
	private String email;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String status;

	private String reset_password;
	
	@UpdateTimestamp
	@Column(name = "reset_password_instance")
	private Instant resetPassInstance;
	
	@OneToOne
    @JoinColumn(name = "fk_role")
    private RoleEntity role;


	
}