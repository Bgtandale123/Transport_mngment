package com.edi.a.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Voyage_Details")
public class VoyageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique  = true)
    private String voyageNumber;

    
    private String rotationNumber;

    private String etaDate;

    private String etdDate;

    private String previousPort;

    private String destinationPort;

    private String intermediatePort;

    private String Route;
    
    private String vesseltype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public String getRotationNumber() {
        return rotationNumber;
    }

    public void setRotationNumber(String rotationNumber) {
        this.rotationNumber = rotationNumber;
    }

    public String getEtaDate() {
        return etaDate;
    }

    public void setEtaDate(String etaDate) {
        this.etaDate = etaDate;
    }

    public String getEtdDate() {
        return etdDate;
    }

    public void setEtdDate(String etdDate) {
        this.etdDate = etdDate;
    }

    public String getPreviousPort() {
        return previousPort;
    }

    public void setPreviousPort(String previousPort) {
        this.previousPort = previousPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getIntermediatePort() {
        return intermediatePort;
    }

    public void setIntermediatePort(String intermediatePort) {
        this.intermediatePort = intermediatePort;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }
    
    public String getVesseltype() {
		return vesseltype;
	}

	public void setVesseltype(String vesseltype) {
		this.vesseltype = vesseltype;
	}

	
    public VoyageDetails() {
    }

    public VoyageDetails(int id, String voyageNumber, String rotationNumber, String etaDate, String etdDate,
			String previousPort, String destinationPort, String intermediatePort, String route, String vesseltype) {
		super();
		this.id = id;
		this.voyageNumber = voyageNumber;
		this.rotationNumber = rotationNumber;
		this.etaDate = etaDate;
		this.etdDate = etdDate;
		this.previousPort = previousPort;
		this.destinationPort = destinationPort;
		this.intermediatePort = intermediatePort;
		Route = route;
		this.vesseltype = vesseltype;
	}

	@Override
	public String toString() {
		return "VoyageDetails [id=" + id + ", voyageNumber=" + voyageNumber + ", rotationNumber=" + rotationNumber
				+ ", etaDate=" + etaDate + ", etdDate=" + etdDate + ", previousPort=" + previousPort
				+ ", destinationPort=" + destinationPort + ", intermediatePort=" + intermediatePort + ", Route=" + Route
				+ ", vesseltype=" + vesseltype + "]";
	}
}
