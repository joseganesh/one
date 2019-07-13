package org.jewellery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="category")
public class CategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CatId")
	private Integer CategoryId;
	
	@Column(name="CategoryCode")
	private String CategoryCode;
	
	@Column(name="CategoryName")
	private String CategoryName;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="status")
	private String status;

	public Integer getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryCode() {
		return CategoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		CategoryCode = categoryCode;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
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
}
