package org.jewellery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="tax")
public class TaxModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TaxId")
	private Integer TaxId;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="SGST")
	private Double SGST;
	
	@Column(name="CGST")
	private Double CGST;
	
	@Column(name="IGST")
	private Double IGST;

	public Integer getTaxId() {
		return TaxId;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public Double getSGST() {
		return SGST;
	}

	public Double getCGST() {
		return CGST;
	}

	public Double getIGST() {
		return IGST;
	}

	public void setTaxId(Integer taxId) {
		TaxId = taxId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSGST(Double sGST) {
		SGST = sGST;
	}

	public void setCGST(Double cGST) {
		CGST = cGST;
	}

	public void setIGST(Double iGST) {
		IGST = iGST;
	}
	
	
	
}
