package jewelleryUtil;

import java.sql.ResultSet;
import java.sql.Statement;

import DB.DbConnection;

public class UpdateUtil 
{
	//to pass the id from grid
		public static String taxEdit(String val1)
		{
			String tax ="";
			
			try {
				String tx="update TaxId,SGST,CGST,Date,Status from tax where TaxId="+val1;
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
			
		}
}
