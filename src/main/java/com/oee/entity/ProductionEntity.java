package com.oee.entity;

import java.util.ArrayList;
import java.util.List;

import com.oee.entity.id.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "production") 
public class ProductionEntity extends BaseEntity {
  
    private String company ;
    private String proddate;
    
    private String availability_lunchtime ;
	private String availability_teatime ;
	private String availability_reviewtime ;
	private double availability_inpectiontime ;
	private double availability_machinebreakdown ;
	private double availability_setupchange ;
	private double availability_nomaterial ;
	private double availability_nolabour ;
	private double availability_inspection ;
	
	private double availability_tooling  ;
	private double availability_drawing  ;
	private double availability_guages  ;
	private double availability_otherlosses;
	private String availability_overtime;
	private String availability_totaltime;
	private String availability_stdloss;
	private String availability_specloss;
	private String availability_totloss;
	// private String availability_calculation;
	private String availability_time;
	private String availability_per;
	 
	private String productivity_searching;
	private String productivity_personnal;
	private String productivity_rework;
	private String productivity_Production_qty ;
	private String productivity_standard_qty;
	private String productivity_per;
	
	private String productivity_Production_availabletime_qty;
	private String productivity_total_utilised_time;
	private String achievement_per;
	private String quality_per;
	 
	private String rejection_rejection_qty;
	private String rejection_ok_qty;
	private String rejection_per;
	private double oee_per;
    
	private double tot_planned_mins;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_unitentity", referencedColumnName = "id")
	private UnitEntity unitentity;
	
	@ManyToOne
	@JoinColumn(name = "fk_planentity", referencedColumnName = "id")
	private PlanningEntity planningEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_workcentreentity", referencedColumnName = "id")
	private WorkcenterEntity workcenterentity;
	
	@ManyToOne
	@JoinColumn(name = "fk_shiftentity", referencedColumnName = "id")
	private ShiftEntity shiftEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_stationentity", referencedColumnName = "id") private
	StationEntity stationEntity ;
    
	@ManyToOne
	@JoinColumn(name = "fk_operatorentity", referencedColumnName = "id")
	private OperatorEntity operatorEntity;
	
	
    
	public double getTot_planned_mins() {
		return tot_planned_mins;
	}
	public void setTot_planned_mins(double tot_planned_mins) {
		this.tot_planned_mins = tot_planned_mins;
	}

    public PlanningEntity getPlanningEntity() {
		return planningEntity;
	}
	public void setPlanningEntity(PlanningEntity planningEntity) {
		this.planningEntity = planningEntity;
	}
  
	
	public double getOee_per() {
		return oee_per;
	}

	public void setOee_per(double oee_per) {
		this.oee_per = oee_per;
	}



	  
		/*
		 * @OneToOne
		 * 
		 * @JoinColumn(name = "fk_itementity", referencedColumnName = "id") private
		 * ItemEntity itemEntity;
		 */
	
	public StationEntity getStationEntity() {
		return stationEntity;
	}


	public void setStationEntity(StationEntity stationEntity) {
		this.stationEntity = stationEntity;
	}
	 
	
  @OneToMany(mappedBy = "productionentity", cascade = CascadeType.ALL, orphanRemoval = true) 
  // @OrderBy("startWeight Asc") 
  private List<ProductionPlanningEntity> productionPlanningEntities = new ArrayList<>();


public String getCompany() {
	return company;
}


public void setCompany(String company) {
	this.company = company;
}




public OperatorEntity getOperatorEntity() {
	return operatorEntity;
}


public void setOperatorEntity(OperatorEntity operatorEntity) {
	this.operatorEntity = operatorEntity;
}


public String getProddate() {
	return proddate;
}


public void setProddate(String proddate) {
	this.proddate = proddate;
}


public UnitEntity getUnitentity() {
	return unitentity;
}


public void setUnitentity(UnitEntity unitentity) {
	this.unitentity = unitentity;
}


public WorkcenterEntity getWorkcenterentity() {
	return workcenterentity;
}


public void setWorkcenterentity(WorkcenterEntity workcenterentity) {
	this.workcenterentity = workcenterentity;
}


public ShiftEntity getShiftEntity() {
	return shiftEntity;
}


public void setShiftEntity(ShiftEntity shiftEntity) {
	this.shiftEntity = shiftEntity;
}

/*
 * public StationEntity getStationEntity() { return stationEntity; }
 * 
 * 
 * public void setStationEntity(StationEntity stationEntity) {
 * this.stationEntity = stationEntity; }
 * 
 * 
 * public ItemEntity getItemEntity() { return itemEntity; }
 * 
 * 
 * public void setItemEntity(ItemEntity itemEntity) { this.itemEntity =
 * itemEntity; }
 */


public String getAvailability_lunchtime() {
	return availability_lunchtime;
}


public void setAvailability_lunchtime(String availability_lunchtime) {
	this.availability_lunchtime = availability_lunchtime;
}


public String getAvailability_teatime() {
	return availability_teatime;
}


public void setAvailability_teatime(String availability_teatime) {
	this.availability_teatime = availability_teatime;
}


public String getAvailability_reviewtime() {
	return availability_reviewtime;
}


public void setAvailability_reviewtime(String availability_reviewtime) {
	this.availability_reviewtime = availability_reviewtime;
}


public double getAvailability_inpectiontime() {
	return availability_inpectiontime;
}


public void setAvailability_inpectiontime(double availability_inpectiontime) {
	this.availability_inpectiontime = availability_inpectiontime;
}


public double getAvailability_machinebreakdown() {
	return availability_machinebreakdown;
}


public void setAvailability_machinebreakdown(double availability_machinebreakdown) {
	this.availability_machinebreakdown = availability_machinebreakdown;
}


public double getAvailability_setupchange() {
	return availability_setupchange;
}


public void setAvailability_setupchange(double availability_setupchange) {
	this.availability_setupchange = availability_setupchange;
}


public double getAvailability_nomaterial() {
	return availability_nomaterial;
}


public void setAvailability_nomaterial(double availability_nomaterial) {
	this.availability_nomaterial = availability_nomaterial;
}


public double getAvailability_nolabour() {
	return availability_nolabour;
}


public void setAvailability_nolabour(double availability_nolabour) {
	this.availability_nolabour = availability_nolabour;
}


public double getAvailability_inspection() {
	return availability_inspection;
}


public void setAvailability_inspection(double availability_inspection) {
	this.availability_inspection = availability_inspection;
}


public double getAvailability_tooling() {
	return availability_tooling;
}


public void setAvailability_tooling(double availability_tooling) {
	this.availability_tooling = availability_tooling;
}


public double getAvailability_drawing() {
	return availability_drawing;
}


public void setAvailability_drawing(double availability_drawing) {
	this.availability_drawing = availability_drawing;
}


public double getAvailability_guages() {
	return availability_guages;
}


public void setAvailability_guages(double availability_guages) {
	this.availability_guages = availability_guages;
}


public double getAvailability_otherlosses() {
	return availability_otherlosses;
}


public void setAvailability_otherlosses(double availability_otherlosses) {
	this.availability_otherlosses = availability_otherlosses;
}





public String getAvailability_overtime() {
	return availability_overtime;
}


public void setAvailability_overtime(String availability_overtime) {
	this.availability_overtime = availability_overtime;
}


public String getAvailability_totaltime() {
	return availability_totaltime;
}


public void setAvailability_totaltime(String availability_totaltime) {
	this.availability_totaltime = availability_totaltime;
}


public String getAvailability_stdloss() {
	return availability_stdloss;
}


public void setAvailability_stdloss(String availability_stdloss) {
	this.availability_stdloss = availability_stdloss;
}


public String getAvailability_specloss() {
	return availability_specloss;
}


public void setAvailability_specloss(String availability_specloss) {
	this.availability_specloss = availability_specloss;
}


public String getAvailability_totloss() {
	return availability_totloss;
}


public void setAvailability_totloss(String availability_totloss) {
	this.availability_totloss = availability_totloss;
}


public String getAvailability_time() {
	return availability_time;
}


public void setAvailability_time(String availability_time) {
	this.availability_time = availability_time;
}


public String getAvailability_per() {
	return availability_per;
}


public void setAvailability_per(String availability_per) {
	this.availability_per = availability_per;
}


public String getProductivity_searching() {
	return productivity_searching;
}


public void setProductivity_searching(String productivity_searching) {
	this.productivity_searching = productivity_searching;
}


public String getProductivity_personnal() {
	return productivity_personnal;
}


public void setProductivity_personnal(String productivity_personnal) {
	this.productivity_personnal = productivity_personnal;
}


public String getProductivity_rework() {
	return productivity_rework;
}


public void setProductivity_rework(String productivity_rework) {
	this.productivity_rework = productivity_rework;
}


public String getProductivity_Production_qty() {
	return productivity_Production_qty;
}


public void setProductivity_Production_qty(String productivity_Production_qty) {
	this.productivity_Production_qty = productivity_Production_qty;
}


public String getProductivity_standard_qty() {
	return productivity_standard_qty;
}


public void setProductivity_standard_qty(String productivity_standard_qty) {
	this.productivity_standard_qty = productivity_standard_qty;
}


public String getProductivity_per() {
	return productivity_per;
}


public void setProductivity_per(String productivity_per) {
	this.productivity_per = productivity_per;
}


public String getRejection_rejection_qty() {
	return rejection_rejection_qty;
}


public void setRejection_rejection_qty(String rejection_rejection_qty) {
	this.rejection_rejection_qty = rejection_rejection_qty;
}


public String getRejection_ok_qty() {
	return rejection_ok_qty;
}


public void setRejection_ok_qty(String rejection_ok_qty) {
	this.rejection_ok_qty = rejection_ok_qty;
}


public String getRejection_per() {
	return rejection_per;
}


public void setRejection_per(String rejection_per) {
	this.rejection_per = rejection_per;
}


public List<ProductionPlanningEntity> getProductionPlanningEntities() {
	return productionPlanningEntities;
}


public void setProductionPlanningEntities(List<ProductionPlanningEntity> productionPlanningEntities) {
	this.productionPlanningEntities = productionPlanningEntities;
	
	for(ProductionPlanningEntity productionPlanningEntity : productionPlanningEntities) {
		
		productionPlanningEntity.setProductionentity(this);
	}
}
public String getProductivity_Production_availabletime_qty() {
	return productivity_Production_availabletime_qty;
}
public void setProductivity_Production_availabletime_qty(String productivity_Production_availabletime_qty) {
	this.productivity_Production_availabletime_qty = productivity_Production_availabletime_qty;
}
public String getProductivity_total_utilised_time() {
	return productivity_total_utilised_time;
}
public void setProductivity_total_utilised_time(String productivity_total_utilised_time) {
	this.productivity_total_utilised_time = productivity_total_utilised_time;
}
public String getAchievement_per() {
	return achievement_per;
}
public void setAchievement_per(String achievement_per) {
	this.achievement_per = achievement_per;
}
public String getQuality_per() {
	return quality_per;
}
public void setQuality_per(String quality_per) {
	this.quality_per = quality_per;
} 
  
  
  
  
 
}