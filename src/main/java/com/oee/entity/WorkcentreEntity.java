package com.oee.entity;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_workcentre")
public class WorkcentreEntity extends BaseEntity {

	private String name ;
	
	@OneToOne
	@JoinColumn(name = "fk_unitentity", referencedColumnName = "id")
	private UnitEntity unitentity;
}
