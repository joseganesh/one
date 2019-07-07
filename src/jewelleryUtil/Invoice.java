package jewelleryUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DbConnection;

public class Invoice 
{
	public static int getinvoice(int invoiceid) throws SQLException
	{
		int invoice=0;
		try {
			
			//String sql="select Amount from rate WHERE Date = (SELECT MAX(Date) FROM rate)";
			String sql="SELECT InvoiceId FROM invoice";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			while (rs.next()) {
				invoice = rs.getInt("InvoiceId");
				 break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoice;
		
		
		
	  
	
	  
	 
	}
}
