package com.oee.entity;

import java.time.Instant;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oee.entity.id.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "emp_info")
@Setter
@Getter
public class UserInfoEntity extends BaseEntity implements UserDetails{
	

	private String mobilenumber;
	private String email;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String status;
	private String firstloginstatus;
	
	private String reset_password;
	
	@UpdateTimestamp
	@Column(name = "reset_password_instance")
	private Instant resetPassInstance;
	
	@ManyToOne
    @JoinColumn(name = "fk_role")
    private RoleEntity role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@ManyToOne
    @JoinColumn(name = "fk_unit")
    private UnitEntity unitentity;
	
	@ManyToOne
    @JoinColumn(name = "fk_workcenter")
    private WorkcenterEntity workcenterentity;
	
	private int logincount;
}