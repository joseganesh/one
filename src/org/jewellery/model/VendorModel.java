package org.jewellery.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="vendor")
public class VendorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VendorId")
	private Integer VendorId;
	
	@Column(name="VendorName")
	private String VendorName;
	
	@Column(name="Address")
	private String VendorAddress;
	
	@Column(name="AatharNo")
	private BigInteger AatharNo;
	
	@Column(name="ContactNo")
	private String VendorContactNo;
	
	@Column(name="VendorCode")
	private String VendorCode;
	
	public Integer getVendorId() {
		return VendorId;
	}

	public String getVendorName() {
		return VendorName;
	}

	public String getVendorAddress() {
		return VendorAddress;
	}

	public BigInteger getAatharNo() {
		return AatharNo;
	}

	public String getVendorContactNo() {
		return VendorContactNo;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setVendorId(Integer vendorId) {
		VendorId = vendorId;
	}

	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}

	public void setVendorAddress(String vendorAddress) {
		VendorAddress = vendorAddress;
	}

	public void setAatharNo(BigInteger aatharNo) {
		AatharNo = aatharNo;
	}

	public void setVendorContactNo(String vendorContactNo) {
		VendorContactNo = vendorContactNo;
	}

	public void setVendorCode(String vendorCode) {
		VendorCode = vendorCode;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="Date")
	private Date date;
	
	@Column(name="Status")
	private String status;
	
	
	
}
