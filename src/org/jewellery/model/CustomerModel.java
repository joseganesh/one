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
@Table(schema="jewellery", name="customer")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private Integer id;
	
	@Column(name="CustomerName")
	private String customerName;
	
	@Column(name="Address")
	private String customerAddress;
	
	@Column(name="ContactNo")
	private String customerContact;
	
	@Column(name="Pin")
	private BigInteger customerPin;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Gender")
	private String Gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public BigInteger getCustomerPin() {
		return customerPin;
	}

	public void setCustomerPin(BigInteger customerPin) {
		this.customerPin = customerPin;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

}
