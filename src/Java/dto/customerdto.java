package Java.dto;

import java.util.List;

public class customerdto 
{
   private String name;
   private String address;
   private String contactNo;
   private String invoice;
   private String totalAmtbefore;
   private String totalTax;
   private String discountInPer;
   private String totalAmount;
   private String amountInWords;
   
   List<SalesDto> saleslist;
	 
	 
	 
	 public List<SalesDto> getSaleslist() {
		return saleslist;
	}
	public void setSaleslist(List<SalesDto> saleslist) {
		this.saleslist = saleslist;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getInvoice() {
	return invoice;
}
public void setInvoice(String invoice) {
	this.invoice = invoice;
}
public String getTotalAmtbefore() {
	return totalAmtbefore;
}
public void setTotalAmtbefore(String totalAmtbefore) {
	this.totalAmtbefore = totalAmtbefore;
}
public String getTotalTax() {
	return totalTax;
}
public void setTotalTax(String totalTax) {
	this.totalTax = totalTax;
}
public String getDiscountInPer() {
	return discountInPer;
}
public void setDiscountInPer(String discountInPer) {
	this.discountInPer = discountInPer;
}
public String getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(String totalAmount) {
	this.totalAmount = totalAmount;
}
public String getAmountInWords() {
	return amountInWords;
}
public void setAmountInWords(String amountInWords) {
	this.amountInWords = amountInWords;
}
}
