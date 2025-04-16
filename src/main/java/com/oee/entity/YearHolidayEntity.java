package com.oee.entity;


import java.util.Set;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "master_year_holiday")
public class YearHolidayEntity extends BaseEntity {

	
	private String name ;
	private String date ;
	
	@ManyToOne
	@JoinColumn(name = "yearentity_id", nullable = false)
	private YearEntity yearentity;
}
