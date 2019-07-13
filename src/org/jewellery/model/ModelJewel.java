package org.jewellery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="model")
public class ModelJewel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ModelId")
	private Integer ModelId;
	
	@Column(name="ModelCode")
	private String ModelCode;
	
	@Column(name="ModelName")
	private String ModelName;
	
	@Column(name="Date")
	private Date Date;
	
	@Column(name="Status")
	private String Status;

	public Integer getModelId() {
		return ModelId;
	}

	public void setModelId(Integer modelId) {
		ModelId = modelId;
	}

	public String getModelCode() {
		return ModelCode;
	}

	public void setModelCode(String modelCode) {
		ModelCode = modelCode;
	}

	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
