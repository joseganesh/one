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
@Table(schema="jewellery", name="rate")
public class RateModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RateId")
	private Integer RateId;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Amount")
	private Double Amount;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="CatId")
	private CategoryModel categorymodel;
	
	@Column(name = "UnitId")
	private Integer UnitId;

	public Integer getRateId() {
		return RateId;
	}

	public Date getDate() {
		return date;
	}

	public Double getAmount() {
		return Amount;
	}

	public String getStatus() {
		return status;
	}

	public CategoryModel getCategorymodel() {
		return categorymodel;
	}

	public Integer getUnitId() {
		return UnitId;
	}

	public void setRateId(Integer rateId) {
		RateId = rateId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCategorymodel(CategoryModel categorymodel) {
		this.categorymodel = categorymodel;
	}

	public void setUnitId(Integer unitId) {
		UnitId = unitId;
	}
}
