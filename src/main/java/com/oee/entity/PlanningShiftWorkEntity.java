package com.oee.entity;
import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_planning_shift_work")
public class PlanningShiftWorkEntity extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "fk_station", referencedColumnName = "id")
	@OrderBy("id Asc")
	private StationEntity station;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "fk_station", referencedColumnName = "id") private
	 * StationEntity station;
	 */
	
	@OneToOne
	@JoinColumn(name = "fk_item", referencedColumnName = "id")
	private ItemEntity item;
	
	@OneToOne
	@JoinColumn(name = "fk_setup", referencedColumnName = "id")
	private SetUpEntity setup;
	
	private String setuptime ;
	
	private String cycletime ;
	
	private String plannedquantity ;
	private String plannedmins ;
	private String itemtimeutilised ;
	
	
	private String machinetimeutilised ;
	
	@ManyToOne
	@JoinColumn(name = "planningentity_id", nullable = false)
	private PlanningEntity planningentity;
}