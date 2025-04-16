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
@Table(name = "SetUpMaster")
public class SetUpEntity extends BaseEntity {

	private String name ;
	private int cycletime ;
	
	@OneToOne
	@JoinColumn(name = "fk_Itementity", referencedColumnName = "id")
	private ItemEntity itementity;
	
	@OneToOne
	@JoinColumn(name = "fk_stationentity", referencedColumnName = "id")
	private StationEntity stationentity;
}
