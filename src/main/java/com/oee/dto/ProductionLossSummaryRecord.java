package com.oee.dto;

public record ProductionLossSummaryRecord(String stationname ,String unit ,String workcenter 
		,double totPlannedMins
		,double availabilityMachinebreakdown
		,double availabilitySetupchange
		,double availabilityNomaterial
		,double availabilityNolabour
		,double availabilityInpectiontime
		,double availabilityTooling
		,double availabilityDrawing
		,double availabilityGuages
		,double availabilityOtherlosses) {
}
