package com.oee.entity;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stationTypeMaster")
public class StationTypeEntity extends BaseEntity {

	private String name ;
	
}
