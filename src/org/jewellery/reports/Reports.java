package org.jewellery.reports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletContext;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
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

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DB.hibernteConnection;
import queryHibernate.jewelHibernate;

public class Reports {
	
	private ProductModel product;
	private CategoryModel category;
	private TaxModel tax;
	private AccountGroupModel acgroup;
	private CashDataModel cashmodel;
	private ModelJewel modeljewel;
	private StockModel stock;
	private UnitModel unit;
	private VendorModel vendor;
	private RateModel rate;
	private jewelHibernate query;
	private List<ProductModel> saleslist;
	ByteArrayOutputStream baos;
	private static final String SUCCESS = "success";
	private static final String FAILED = "failed";
	hibernteConnection hb = new hibernteConnection();
	private String Filename;
	private String DocumentType;
	
	public void generateSalesInvoice(CashDataModel cashDataModel ,SalesScreenModel salesScreenModel, CustomerModel customermodel){
		
		product=hb.getProducts();
		try {
			Document document = new Document(PageSize.A4);
			Filename=cashmodel.getInvoiceno();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(Filename+".pdf"));
			PdfPTable pdfpTable;
			Chunk chunk;
			String temp;
			Paragraph paragraph;
			PdfPCell cell;
			PdfContentByte cb;

			document.open();
			document.addTitle("Sales Invoice");
			document.setMargins(5, 5, 5, 5);
			
			//1st invoice number
	        temp=cashDataModel.getInvoiceno().toString();
			
			paragraph=new Paragraph();
			Font font=new Font(FontFamily.HELVETICA, 8, Font.BOLDITALIC);
			chunk = new Chunk(temp, font);
			paragraph.add(chunk);
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph);
			
			//2nd add image left side
			 String filename = "other-sample/src/main/resources/java.gif";
	         Image image = Image.getInstance(filename);
	         image.setAbsolutePosition(0f, 0f);
	         document.add(image);
	         
	         //right side set the name
	         paragraph=new Paragraph();
			 Font font1=new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC);
			 temp="NAME OF THE ...";
			 chunk = new Chunk(temp, font1);
			 paragraph.add(chunk);
			 paragraph.setAlignment(Element.ALIGN_RIGHT);
			 document.add(paragraph);
			 
			 
		
			
			
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	



}
