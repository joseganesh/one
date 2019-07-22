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
@Table(schema="jewellery", name="stock")
public class StockModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StockId")
	private Integer StockId;
	
	@ManyToOne
	@JoinColumn(name="ProductId")
	private ProductModel productmodel;
	
	@ManyToOne
	@JoinColumn(name="ModelId")
	private ModelJewel modeljewel;
	
	@Column(name="Quantity")
	private Double Quantity; 
	
	@Column(name="NetWt")
	private Double NetWt; 
	
	@Column(name="Date")
	private Date date;

	public Integer getStockId() {
		return StockId;
	}

	public ProductModel getProductmodel() {
		return productmodel;
	}

	public ModelJewel getModeljewel() {
		return modeljewel;
	}

	public Double getQuantity() {
		return Quantity;
	}

	public Double getNetWt() {
		return NetWt;
	}

	public Date getDate() {
		return date;
	}

	public void setStockId(Integer stockId) {
		StockId = stockId;
	}

	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}

	public void setModeljewel(ModelJewel modeljewel) {
		this.modeljewel = modeljewel;
	}

	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}

	public void setNetWt(Double netWt) {
		NetWt = netWt;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
