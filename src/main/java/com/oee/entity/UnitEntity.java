package com.oee.entity;


import java.util.Set;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_unit")
public class UnitEntity extends BaseEntity {

	private String name ;
	
	@OneToOne
	@JoinColumn(name = "fk_companyentity", referencedColumnName = "id")
	private CompanyEntity companyentity;
	
	@OneToMany(mappedBy = "unitentity", cascade = CascadeType.ALL)
//	@OrderBy("startWeight Asc")
	private Set<ShiftEntity> shiftentities;
}
