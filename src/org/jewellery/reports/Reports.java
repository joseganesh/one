package org.jewellery.reports;

import java.io.File;
import java.util.List;

import javax.management.Query;
import javax.swing.JOptionPane;

import org.jewellery.model.AccountGroupModel;
import org.jewellery.model.CashDataModel;
import org.jewellery.model.CategoryModel;
import org.jewellery.model.CustomerModel;
import org.jewellery.model.ModelJewel;
import org.jewellery.model.ProductModel;
import org.jewellery.model.RateModel;
import org.jewellery.model.SalesScreenModel;
import org.jewellery.model.StockModel;
import org.jewellery.model.TaxModel;
import org.jewellery.model.UnitModel;
import org.jewellery.model.VendorModel;

import DB.hibernteConnection;
import queryHibernate.jewelHibernate;

public class Reports {
	
	private ProductModel product;
	private CategoryModel category;
	private TaxModel tax;
	private AccountGroupModel acgroup;
	private CashDataModel cashmodel;
	private CustomerModel customer;
	private ModelJewel modeljewel;
	private SalesScreenModel salesscreen;
	private StockModel stock;
	private UnitModel unit;
	private VendorModel vendor;
	private RateModel rate;
	private jewelHibernate query;
	private List<ProductModel> saleslist;
	
	hibernteConnection hb = new hibernteConnection();
	
	public void generateSalesInvoice(int salesid){
		
		product=hb.getProducts();
		saleslist= query.getsalesinvoice(salesid);
		String fileLocation;
		String destinationPath = null;
		File destination;
		JOptionPane.showMessageDialog(null, product.getProductName());
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
