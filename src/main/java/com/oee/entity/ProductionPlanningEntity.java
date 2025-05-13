package com.oee.entity;

import com.oee.entity.id.BaseEntity;

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
@Table(name = "production_planning") 
public class ProductionPlanningEntity extends BaseEntity {
  
	@OneToOne
	@JoinColumn(name = "fk_companyentity", referencedColumnName = "id")
	private CompanyEntity companyentity;

	@OneToOne
	@JoinColumn(name = "fk_item", referencedColumnName = "id")
	private ItemEntity item;

	@OneToOne
	@JoinColumn(name = "fk_setup", referencedColumnName = "id")
	private SetUpEntity setup;

	private String qty_planned;
	private String qty_produced;
	private String qty_rejected;
  
	@ManyToOne
	@JoinColumn(name = "productionentity_id")
	private ProductionEntity productionentity;
 
}