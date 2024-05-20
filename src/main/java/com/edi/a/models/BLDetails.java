package com.edi.a.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "BL_Information")
public class BLDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

   // @Column(unique = true)
	private String blno;

	private String designation;
	
	private String shipperName;

	private String shipperAddress;

	private String consigneeName;

	private String consigneeAddress;

	private String notifyPartyName;

	private String notifyPartyAddress;
	
	private String por;

	private String pol;
	
	private String pod;
	
	private String fpod;
	
	private String carrierInformation;

	//private String carrierInfoId;
	
	private String vesseltype;

	private String voyage;
	
	private String hscode;

	//private String voyageID;

	private String goodsDescription;

	//private String shippingContainerCount;

	private String marksAndNumbers;

	//private String bL_Informationcol;

	@OneToMany(mappedBy = "blid")
	private List<BLContainerInfo> shippingContainerInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlno() {
		return blno;
	}

	public void setBlno(String blno) {
		this.blno = blno;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPor() {
		return por;
	}

	public void setPor(String por) {
		this.por = por;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getFpod() {
		return fpod;
	}

	public void setFpod(String fpod) {
		this.fpod = fpod;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getNotifyPartyName() {
		return notifyPartyName;
	}

	public void setNotifyPartyName(String notifyPartyName) {
		this.notifyPartyName = notifyPartyName;
	}

	public String getNotifyPartyAddress() {
		return notifyPartyAddress;
	}

	public void setNotifyPartyAddress(String notifyPartyAddress) {
		this.notifyPartyAddress = notifyPartyAddress;
	}

	public String getCarrierInformation() {
		return carrierInformation;
	}

	public void setCarrierInformation(String carrierInformation) {
		this.carrierInformation = carrierInformation;
	}

	/*
	 * public String getCarrierInfoId() { return carrierInfoId; }
	 * 
	 * public void setCarrierInfoId(String carrierInfoId) { this.carrierInfoId =
	 * carrierInfoId; }
	 * 
	 * public String getVessel() { return vessel; }
	 
	*public void setVessel(String vessel) {
	*	this.vessel = vessel;
	*}
	*/

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	
	
    public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	/*
	 * public String getVoyageID() { return voyageID; }
	 * 
	 * public void setVoyageID(String voyageID) { this.voyageID = voyageID; }
	 */
	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	/*
	 * public String getShippingContainerCount() { return shippingContainerCount; }
	 * 
	 * public void setShippingContainerCount(String shippingContainerCount) {
	 * this.shippingContainerCount = shippingContainerCount; }
	 */
	public String getMarksAndNumbers() {
		return marksAndNumbers;
	}

	public void setMarksAndNumbers(String marksAndNumbers) {
		this.marksAndNumbers = marksAndNumbers;
	}

	/*
	 * public String getbL_Informationcol() { return bL_Informationcol; }
	 * 
	 * public void setbL_Informationcol(String bL_Informationcol) {
	 * this.bL_Informationcol = bL_Informationcol; }
	 */
	public List<BLContainerInfo> getShippingContainerInfo() {
		return shippingContainerInfo;
	}

	public void setShippingContainerInfo(List<BLContainerInfo> shippingContainerInfo) {
		this.shippingContainerInfo = shippingContainerInfo;
	}

	

	public String getVesseltype() {
		return vesseltype;
	}

	public void setVesseltype(String vesseltype) {
		this.vesseltype = vesseltype;
	}

	public BLDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
		public BLDetails(int id, String blno, String designation, String shipperName, String shipperAddress,
			String consigneeName, String consigneeAddress, String notifyPartyName, String notifyPartyAddress,
			String por, String pol, String pod, String fpod, String carrierInformation, String vesseltype,
			String voyage, String hscode, String goodsDescription, String marksAndNumbers,
			List<BLContainerInfo> shippingContainerInfo) {
		super();
		this.id = id;
		this.blno = blno;
		this.designation = designation;
		this.shipperName = shipperName;
		this.shipperAddress = shipperAddress;
		this.consigneeName = consigneeName;
		this.consigneeAddress = consigneeAddress;
		this.notifyPartyName = notifyPartyName;
		this.notifyPartyAddress = notifyPartyAddress;
		this.por = por;
		this.pol = pol;
		this.pod = pod;
		this.fpod = fpod;
		this.carrierInformation = carrierInformation;
		this.vesseltype = vesseltype;
		this.voyage = voyage;
		this.hscode = hscode;
		this.goodsDescription = goodsDescription;
		this.marksAndNumbers = marksAndNumbers;
		this.shippingContainerInfo = shippingContainerInfo;
	}

		@Override
		public String toString() {
			return "BLDetails [id=" + id + ", blno=" + blno + ", designation=" + designation + ", shipperName="
					+ shipperName + ", shipperAddress=" + shipperAddress + ", consigneeName=" + consigneeName
					+ ", consigneeAddress=" + consigneeAddress + ", notifyPartyName=" + notifyPartyName
					+ ", notifyPartyAddress=" + notifyPartyAddress + ", por=" + por + ", pol=" + pol + ", pod=" + pod
					+ ", fpod=" + fpod + ", carrierInformation=" + carrierInformation + ", vesseltype=" + vesseltype
					+ ", voyage=" + voyage + ", hscode=" + hscode + ", goodsDescription=" + goodsDescription
					+ ", marksAndNumbers=" + marksAndNumbers + ", shippingContainerInfo=" + shippingContainerInfo + "]";
		}

	

}