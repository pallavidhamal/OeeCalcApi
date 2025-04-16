package com.oee.entity;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ItemMaster")
public class ItemEntity extends BaseEntity {

	@Column(name = "itemcode")
	private String itemcode ;
	
	@Column(name = "itemdesc")
	private String itemdesc ;
	
}
