package com.oee.entity;

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
@Table(name = "master_availabilty_loss")
public class AvailabiltyLossEntity extends BaseEntity {

	
	private String name ;
	private String lossestype ;
	private String timeinmin ;
	
}
