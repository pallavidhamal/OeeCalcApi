package com.oee.entity;


import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_company")
public class CompanyEntity extends BaseEntity {

	private String name ;
	
}
