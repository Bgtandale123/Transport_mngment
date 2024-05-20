package com.edi.a.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vessel_Information")
public class Vessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique  = true)
    private String vesselId;

    private String vesselName;

    private String vesselOperator;
    @Column(unique  = true)
    private String imoNumber;

    private String flagState;
    @Column(unique  = true)
    private String callSign;

    private String yearOfBuilt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getVesselOperator() {
		return vesselOperator;
	}

	public void setVesselOperator(String vesselOperator) {
		this.vesselOperator = vesselOperator;
	}

	public String getImoNumber() {
		return imoNumber;
	}

	public void setImoNumber(String imoNumber) {
		this.imoNumber = imoNumber;
	}

	public String getFlagState() {
		return flagState;
	}

	public void setFlagState(String flagState) {
		this.flagState = flagState;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public String getYearOfBuilt() {
		return yearOfBuilt;
	}

	public void setYearOfBuilt(String yearOfBuilt) {
		this.yearOfBuilt = yearOfBuilt;
	}

	public Vessel(int id, String vesselId, String vesselName, String vesselOperator, String imoNumber, String flagState,
			String callSign, String yearOfBuilt) {
		super();
		this.id = id;
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.vesselOperator = vesselOperator;
		this.imoNumber = imoNumber;
		this.flagState = flagState;
		this.callSign = callSign;
		this.yearOfBuilt = yearOfBuilt;
	}

	public Vessel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vessel [id=" + id + ", vesselId=" + vesselId + ", vesselName=" + vesselName + ", vesselOperator="
				+ vesselOperator + ", imoNumber=" + imoNumber + ", flagState=" + flagState + ", callSign=" + callSign
				+ ", yearOfBuilt=" + yearOfBuilt + "]";
	}

	    
}
