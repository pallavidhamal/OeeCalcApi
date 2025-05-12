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
@Table(name = "master_shift")
public class ShiftEntity extends BaseEntity {

	private String name ;
	private String shifthour ;
	
	@ManyToOne
    @JoinColumn(name = "unitentity_id")
    private UnitEntity unitentity;
}