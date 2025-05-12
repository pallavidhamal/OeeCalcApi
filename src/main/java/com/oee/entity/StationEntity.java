
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
@Table(name = "stationMaster")
public class StationEntity extends BaseEntity {

	private String name;

	@OneToOne

	@JoinColumn(name = "fk_uomentity", referencedColumnName = "id")
	private UomEntity uomentity;

	@OneToOne

	@JoinColumn(name = "fk_workcentreentity", referencedColumnName = "id")
	private WorkcenterEntity workcenterentity;

	@OneToOne

	@JoinColumn(name = "fk_stationtypeentity", referencedColumnName = "id")
	private StationTypeEntity stationtypeentity;

}
