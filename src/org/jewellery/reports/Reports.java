package org.jewellery.reports;

import javax.swing.JOptionPane;


import org.jewellery.model.ProductModel;

import DB.hibernteConnection;

public class Reports {
	
	private ProductModel product;
	hibernteConnection hb = new hibernteConnection();
	
	public void generateSalesInvoice(){
		
		product=hb.getProducts();
		
		JOptionPane.showMessageDialog(null, product.getProductName());
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
