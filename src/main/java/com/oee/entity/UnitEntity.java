package com.oee.entity;

import java.util.ArrayList;
import java.util.List;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_unit") 
public class UnitEntity extends BaseEntity {
  
  private String name ;
  
  @OneToOne
  @JoinColumn(name = "fk_companyentity", referencedColumnName = "id") private
  CompanyEntity companyentity;
  
  // @OneToMany(mappedBy = "unitentity", cascade = CascadeType.ALL)
  // @OrderBy("startWeight Asc") // private Set<ShiftEntity> shiftentities;
  
  @OneToMany(mappedBy = "unitentity", cascade = CascadeType.ALL, orphanRemoval = true) 
  // @OrderBy("startWeight Asc") 
  private List<ShiftEntity> shiftentities = new ArrayList<>();

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public CompanyEntity getCompanyentity() {
	return companyentity;
}

public void setCompanyentity(CompanyEntity companyentity) {
	this.companyentity = companyentity;
}

public List<ShiftEntity> getShiftentities() {
	return shiftentities;
}

public void setShiftentities(List<ShiftEntity> shiftentities) {
	this.shiftentities = shiftentities;
	for(ShiftEntity shiftEntity : shiftentities) {
		
		shiftEntity.setUnitentity(this);
	}
} 
 
  
}
