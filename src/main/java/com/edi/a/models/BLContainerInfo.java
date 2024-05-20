package com.edi.a.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "shippingContainerInfo")
public class BLContainerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int blid;

	private String containerNumber;

	private String containerType;

	private String sealNumber;
	
	private String no_of_package;

	private String packagetype;


	private String grossWt;
	
	private String dimension;

	private String tareWt;

	private String vgm;

	private String dg;
	
	
	private String unNumber;

	private String ImcoClass;
	
    private String flashPoint;
	
	private String flashPointUnit;

	private String cLASS;

	private String reefer;
	
	private String temp;

	private String tempunit;


	private String tempRequired;

	//private String createdDate;

	//private String updatedDate;
	
	private String oog;
	
	private String position1;
	
	private String position2;
	
	private String position3;
	
	private String position4;
	
	private String position5;
	
	private String oogvalue1;
	
	private String oogvalue2;
	
	private String oogvalue3;
	
	private String oogvalue4;
	
	private String oogvalue5;
	

	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBlid() {
		return blid;
	}


	public void setBlid(int blid) {
		this.blid = blid;
	}


	public String getContainerNumber() {
		return containerNumber;
	}


	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}


	public String getContainerType() {
		return containerType;
	}


	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}


	public String getSealNumber() {
		return sealNumber;
	}


	public void setSealNumber(String sealNumber) {
		this.sealNumber = sealNumber;
	}


	public String getNo_of_package() {
		return no_of_package;
	}


	public void setNo_of_package(String no_of_package) {
		this.no_of_package = no_of_package;
	}


	public String getPackagetype() {
		return packagetype;
	}


	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}


	public String getGrossWt() {
		return grossWt;
	}


	public void setGrossWt(String grossWt) {
		this.grossWt = grossWt;
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public String getTareWt() {
		return tareWt;
	}


	public void setTareWt(String tareWt) {
		this.tareWt = tareWt;
	}


	public String getVgm() {
		return vgm;
	}


	public void setVgm(String vgm) {
		this.vgm = vgm;
	}


	public String getDg() {
		return dg;
	}


	public void setDg(String dg) {
		this.dg = dg;
	}


	public String getUnNumber() {
		return unNumber;
	}


	public void setUnNumber(String unNumber) {
		this.unNumber = unNumber;
	}


	public String getImcoClass() {
		return ImcoClass;
	}


	public void setImcoClass(String imcoClass) {
		ImcoClass = imcoClass;
	}


	public String getFlashPoint() {
		return flashPoint;
	}


	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
	}


	public String getFlashPointUnit() {
		return flashPointUnit;
	}


	public void setFlashPointUnit(String flashPointUnit) {
		this.flashPointUnit = flashPointUnit;
	}


	public String getcLASS() {
		return cLASS;
	}


	public void setcLASS(String cLASS) {
		this.cLASS = cLASS;
	}


	public String getReefer() {
		return reefer;
	}


	public void setReefer(String reefer) {
		this.reefer = reefer;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}


	public String getTempunit() {
		return tempunit;
	}


	public void setTempunit(String tempunit) {
		this.tempunit = tempunit;
	}


	public String getTempRequired() {
		return tempRequired;
	}


	public void setTempRequired(String tempRequired) {
		this.tempRequired = tempRequired;
	}


	public String getOog() {
		return oog;
	}


	public void setOog(String oog) {
		this.oog = oog;
	}


	public String getPosition1() {
		return position1;
	}


	public void setPosition1(String position1) {
		this.position1 = position1;
	}


	public String getPosition2() {
		return position2;
	}


	public void setPosition2(String position2) {
		this.position2 = position2;
	}


	public String getPosition3() {
		return position3;
	}


	public void setPosition3(String position3) {
		this.position3 = position3;
	}


	public String getPosition4() {
		return position4;
	}


	public void setPosition4(String position4) {
		this.position4 = position4;
	}


	public String getPosition5() {
		return position5;
	}


	public void setPosition5(String position5) {
		this.position5 = position5;
	}


	public String getOogvalue1() {
		return oogvalue1;
	}


	public void setOogvalue1(String oogvalue1) {
		this.oogvalue1 = oogvalue1;
	}


	public String getOogvalue2() {
		return oogvalue2;
	}


	public void setOogvalue2(String oogvalue2) {
		this.oogvalue2 = oogvalue2;
	}


	public String getOogvalue3() {
		return oogvalue3;
	}


	public void setOogvalue3(String oogvalue3) {
		this.oogvalue3 = oogvalue3;
	}


	public String getOogvalue4() {
		return oogvalue4;
	}


	public void setOogvalue4(String oogvalue4) {
		this.oogvalue4 = oogvalue4;
	}


	public String getOogvalue5() {
		return oogvalue5;
	}


	public void setOogvalue5(String oogvalue5) {
		this.oogvalue5 = oogvalue5;
	}


	

	public BLContainerInfo(int id, int blid, String containerNumber, String containerType, String sealNumber,
			String no_of_package, String packagetype, String grossWt, String dimension, String tareWt, String vgm,
			String dg, String unNumber, String imcoClass, String flashPoint, String flashPointUnit, String cLASS,
			String reefer, String temp, String tempunit, String tempRequired, String oog, String position1,
			String position2, String position3, String position4, String position5, String oogvalue1, String oogvalue2,
			String oogvalue3, String oogvalue4, String oogvalue5) {
		super();
		this.id = id;
		this.blid = blid;
		this.containerNumber = containerNumber;
		this.containerType = containerType;
		this.sealNumber = sealNumber;
		this.no_of_package = no_of_package;
		this.packagetype = packagetype;
		this.grossWt = grossWt;
		this.dimension = dimension;
		this.tareWt = tareWt;
		this.vgm = vgm;
		this.dg = dg;
		this.unNumber = unNumber;
		ImcoClass = imcoClass;
		this.flashPoint = flashPoint;
		this.flashPointUnit = flashPointUnit;
		this.cLASS = cLASS;
		this.reefer = reefer;
		this.temp = temp;
		this.tempunit = tempunit;
		this.tempRequired = tempRequired;
		this.oog = oog;
		this.position1 = position1;
		this.position2 = position2;
		this.position3 = position3;
		this.position4 = position4;
		this.position5 = position5;
		this.oogvalue1 = oogvalue1;
		this.oogvalue2 = oogvalue2;
		this.oogvalue3 = oogvalue3;
		this.oogvalue4 = oogvalue4;
		this.oogvalue5 = oogvalue5;
	}


	public BLContainerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BLContainerInfo [id=" + id + ", blid=" + blid + ", containerNumber=" + containerNumber
				+ ", containerType=" + containerType + ", sealNumber=" + sealNumber + ", no_of_package=" + no_of_package
				+ ", packagetype=" + packagetype + ", grossWt=" + grossWt + ", dimension=" + dimension + ", tareWt="
				+ tareWt + ", vgm=" + vgm + ", dg=" + dg + ", unNumber=" + unNumber + ", ImcoClass=" + ImcoClass
				+ ", flashPoint=" + flashPoint + ", flashPointUnit=" + flashPointUnit + ", cLASS=" + cLASS + ", reefer="
				+ reefer + ", temp=" + temp + ", tempunit=" + tempunit + ", tempRequired=" + tempRequired + ", oog="
				+ oog + ", position1=" + position1 + ", position2=" + position2 + ", position3=" + position3
				+ ", position4=" + position4 + ", position5=" + position5 + ", oogvalue1=" + oogvalue1 + ", oogvalue2="
				+ oogvalue2 + ", oogvalue3=" + oogvalue3 + ", oogvalue4=" + oogvalue4 + ", oogvalue5=" + oogvalue5
				+ "]";
	}

	
	

	
	
}
