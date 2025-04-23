package com.oee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.oee.entity.id.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mst_role")
@Setter @Getter
public class RoleEntity extends BaseEntity{
	
	private String name;
	@Column(name="name_code")
	private String namecode;
	private String status;
	
}
