package jewelleryUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.DbConnection;
import model.DropDownItem;

public class CommonUtil {
	
	
	public static Vector getAllModel(){
		Vector mode =new Vector();
		try {
			String mod="select ModelId,ModelName from model";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(mod);
			while(rs.next()){
				mode.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mode;
		
	}
	
	public static Vector getAllCatageory(){
		Vector model =new Vector();
		try {
			String cat="select CatId,CategoryName from category";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(cat);
			while(rs.next()){
				model.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
	}
	public static Vector getCatageorycode(){
		Vector Catageorycode =new Vector();
		try {
			String cat="select CatId,CategoryCode from category";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(cat);
			while(rs.next()){
				Catageorycode.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Catageorycode;
		
	}
	
	public static Vector getAllunit(){
		Vector modelunit =new Vector();
		try {
			String unit="select UnitId,Carat from unit";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(unit);
			while(rs.next()){
				modelunit.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelunit;
		
	}

	public static Vector getProductName(){
		Vector ProductName =new Vector();
		try {
			String unit="select ProductId,ProductName from product";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(unit);
			while(rs.next()){
				ProductName.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ProductName;
		
	}
	public static Vector getProductCode(){
		Vector ProductCode =new Vector();
		try {
			String unit="select ProductId,ProductCode from product";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(unit);
			while(rs.next()){
				ProductCode.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ProductCode;
		
	}
	
	
	public static Vector getAccgrp(){
		Vector AccntName =new Vector();
		try {
			String unit="select AccountGroupId,AccountName from accountgroup";
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs =tm.executeQuery(unit);
			while(rs.next()){
				AccntName.addElement(new DropDownItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AccntName;
		
	}
	
	
	
	
/*	//to pass the id from grid
	public static String taxEdit(String val1)
	{
		String tax ="";
		
		try {
			String tx="select * from tax where TaxId="+val1;
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs=tm.executeQuery(tx);
			while(rs.next())
			{
				tax=rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tax;
		
	}*/
	
	
	
	

	
}
