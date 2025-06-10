package com.oee.entity;
import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_planning_stations")
public class PlanningStationsEntity extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "fk_station", referencedColumnName = "id")
	private StationEntity station;
	
	private String timeutilised ;
	
	@ManyToOne
	@JoinColumn(name = "planningentity_id", nullable = false)
	private PlanningEntity planningentity;
}