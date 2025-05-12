package com.oee.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_year")
public class YearEntity extends BaseEntity {

	private String name ;
	
	@OneToMany(mappedBy = "yearentity", cascade = CascadeType.ALL , orphanRemoval = true)
//	@OrderBy("startWeight Asc")
	private List<YearHolidayEntity> yearholidayentities = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}