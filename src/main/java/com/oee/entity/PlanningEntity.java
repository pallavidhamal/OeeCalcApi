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
import lombok.Getter;
import lombok.Setter;


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
	
	@OneToOne
	@JoinColumn(name = "fk_shift", referencedColumnName = "id")
	private ShiftEntity shift;
	
	
	@Column(name = "fromDate")
	private String fromdate ;
	
	@Column(name = "toDate")
	private String todate ;
	
	@Column(name = "timePerShift")
	private String timepershift ;
	
	@OneToMany(mappedBy = "planningentity", cascade = CascadeType.ALL )
//	@OrderBy("startWeight Asc")
	private List<PlanningShiftWorkEntity> planningSiftWorkEntities = new ArrayList<>();
	
	
//	@OneToMany(mappedBy = "planningentity", cascade = CascadeType.ALL , orphanRemoval = true)
//	@OrderBy("startWeight Asc")
//	private List<PlanningStationsEntity> planningStationsEntity = new ArrayList<>();
	
	

	public UnitEntity getUnitentity() {
		return unitentity;
	}

	public void setUnitentity(UnitEntity unitentity) {
		this.unitentity = unitentity;
	}

	public WorkcenterEntity getWorkcenterentity() {
		return workcenterentity;
	}

	public void setWorkcenterentity(WorkcenterEntity workcenterentity) {
		this.workcenterentity = workcenterentity;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getTimepershift() {
		return timepershift;
	}

	public void setTimepershift(String timepershift) {
		this.timepershift = timepershift;
	}

	public List<PlanningShiftWorkEntity> getPlanningSiftWorkEntities() {
		return planningSiftWorkEntities;
	}

	public void setPlanningSiftWorkEntities(List<PlanningShiftWorkEntity> planningSiftWorkEntities) {
		this.planningSiftWorkEntities = planningSiftWorkEntities;
		
		for(PlanningShiftWorkEntity planningShiftWorkEntity: planningSiftWorkEntities)
		{
			planningShiftWorkEntity.setPlanningentity(this);
		}
		
	}

	public ShiftEntity getShift() {
		return shift;
	}

	public void setShift(ShiftEntity shift) {
		this.shift = shift;
	}
}