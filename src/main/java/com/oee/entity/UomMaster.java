package com.oee.entity;

import java.util.Date;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "UomMaster")
public class UomMaster extends BaseEntity {

	private String uom ;
	
}
