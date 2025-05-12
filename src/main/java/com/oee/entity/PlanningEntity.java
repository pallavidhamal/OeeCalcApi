package com.oee.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "master_planning")
public class PlanningEntity extends BaseEntity {

	//@Column(name = "fk_unit")
	//private UnitEntity unitEntity ;
	
	@OneToOne
	@JoinColumn(name = "fk_unitentity", referencedColumnName = "id")
	private UnitEntity unitentity;
	
	@OneToOne
	@JoinColumn(name = "fk_workcentreentity", referencedColumnName = "id")
	private WorkcenterEntity workcenterentity;
	
	@Column(name = "fromDate")
	private String fromdate ;
	
	@Column(name = "toDate")
	private String todate ;
	
	@Column(name = "timePerShift")
	private String timepershift ;
	
	@OneToMany(mappedBy = "planningentity", cascade = CascadeType.ALL , orphanRemoval = true)
//	@OrderBy("startWeight Asc")
	private List<PlanningSiftWorkEntity> planningSiftWorkEntities = new ArrayList<>();
	
}