package org.jewellery.model;

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
public class SalesScreenModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SalesScreenId")
	private Integer SalesScreenId;
	
	@Column(name="HSNCode")
	private String HSNCode;

	@Column(name="Quantity")
	private Double Quantity;
	
	@Column(name="Gwt")
	private Double GramWt;
	
	@Column(name="Swt")
	private Double StoneWt;
	
	@Column(name="Netwt")
	private Double Netwt;
	
	@Column(name="Rate")
	private Double Rate;
	
	@Column(name="Va")
	private Double VA;
	
	@Column(name="AfterDis")
	private Double AfterDis;
	
	@Column(name="StoneCash")
	private Double StoneCash;
	
	@Column(name="Totalamount")
	private Double Totalamount;
	
	@ManyToOne
	@JoinColumn(name="ProductName")
	private ProductModel productmodel;
	
	@ManyToOne
	@JoinColumn(name="ProductCode")
	private CategoryModel categorymodel;
	
	@ManyToOne
	@JoinColumn(name="ModelId")
	private ModelJewel modeljewel;
	
	@ManyToOne
	@JoinColumn(name="CashDataId")
	private CashDataModel cashdatamodel;

	public Integer getSalesScreenId() {
		return SalesScreenId;
	}

	public void setSalesScreenId(Integer salesScreenId) {
		SalesScreenId = salesScreenId;
	}

	public String getHSNCode() {
		return HSNCode;
	}

	public void setHSNCode(String hSNCode) {
		HSNCode = hSNCode;
	}

	public Double getQuantity() {
		return Quantity;
	}

	public void setQuantity(Double quantity) {
		Quantity = quantity;
	}

	public Double getGramWt() {
		return GramWt;
	}

	public void setGramWt(Double gramWt) {
		GramWt = gramWt;
	}

	public Double getStoneWt() {
		return StoneWt;
	}

	public void setStoneWt(Double stoneWt) {
		StoneWt = stoneWt;
	}

	public Double getNetwt() {
		return Netwt;
	}

	public void setNetwt(Double netwt) {
		Netwt = netwt;
	}

	public Double getRate() {
		return Rate;
	}

	public void setRate(Double rate) {
		Rate = rate;
	}

	public Double getVA() {
		return VA;
	}

	public void setVA(Double vA) {
		VA = vA;
	}

	public Double getAfterDis() {
		return AfterDis;
	}

	public void setAfterDis(Double afterDis) {
		AfterDis = afterDis;
	}

	public Double getStoneCash() {
		return StoneCash;
	}

	public void setStoneCash(Double stoneCash) {
		StoneCash = stoneCash;
	}

	public Double getTotalamount() {
		return Totalamount;
	}

	public void setTotalamount(Double totalamount) {
		Totalamount = totalamount;
	}

	public ProductModel getProductmodel() {
		return productmodel;
	}

	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}

	public CategoryModel getCategorymodel() {
		return categorymodel;
	}

	public void setCategorymodel(CategoryModel categorymodel) {
		this.categorymodel = categorymodel;
	}

	public ModelJewel getModeljewel() {
		return modeljewel;
	}

	public void setModeljewel(ModelJewel modeljewel) {
		this.modeljewel = modeljewel;
	}

	public CashDataModel getCashdatamodel() {
		return cashdatamodel;
	}

	public void setCashdatamodel(CashDataModel cashdatamodel) {
		this.cashdatamodel = cashdatamodel;
	}
}
