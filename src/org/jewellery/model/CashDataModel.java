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
@Table(schema="jewellery", name="salesscreen")
public class CashDataModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CashDataId")
	private Integer CashDataId;
	
	@Column(name="Cash")
	private String Cash;

	@Column(name="Cashdiscount")
	private Double Cashdiscount;
	
	@Column(name="Taxrs")
	private Double Taxrs;
	
	@Column(name="Cgst")
	private Double Cgst;
	
	@Column(name="Sgst")
	private Double Sgst;
	
	@Column(name="IGST")
	private Double IGST;
	
	@Column(name="Totalamtpay")
	private Double Totalamtpay;
	
	@Column(name="Amntinwords")
	private String Amntinwords;
	
	@Column(name="Invoiceno")
	private String Invoiceno;
	
	@Column(name="Date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private CustomerModel customermodel;

	public Integer getCashDataId() {
		return CashDataId;
	}

	public void setCashDataId(Integer cashDataId) {
		CashDataId = cashDataId;
	}

	public String getCash() {
		return Cash;
	}

	public void setCash(String cash) {
		Cash = cash;
	}

	public Double getCashdiscount() {
		return Cashdiscount;
	}

	public void setCashdiscount(Double cashdiscount) {
		Cashdiscount = cashdiscount;
	}

	public Double getTaxrs() {
		return Taxrs;
	}

	public void setTaxrs(Double taxrs) {
		Taxrs = taxrs;
	}

	public Double getCgst() {
		return Cgst;
	}

	public void setCgst(Double cgst) {
		Cgst = cgst;
	}

	public Double getSgst() {
		return Sgst;
	}

	public void setSgst(Double sgst) {
		Sgst = sgst;
	}

	public Double getIGST() {
		return IGST;
	}

	public void setIGST(Double iGST) {
		IGST = iGST;
	}

	public Double getTotalamtpay() {
		return Totalamtpay;
	}

	public void setTotalamtpay(Double totalamtpay) {
		Totalamtpay = totalamtpay;
	}

	public String getAmntinwords() {
		return Amntinwords;
	}

	public void setAmntinwords(String amntinwords) {
		Amntinwords = amntinwords;
	}

	public String getInvoiceno() {
		return Invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		Invoiceno = invoiceno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CustomerModel getCustomermodel() {
		return customermodel;
	}

	public void setCustomermodel(CustomerModel customermodel) {
		this.customermodel = customermodel;
	}
	
}
