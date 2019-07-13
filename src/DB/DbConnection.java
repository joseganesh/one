package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	 private static Connection conn=null;
		public static Connection getconnection()
		{
		try {
			 
			if(conn==null){
				Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewellery","root","");
		//	JOptionPane.showMessageDialog(null, "connected sucessfully!");
			
			}
			return conn;
			
		} catch (Exception e) {
			
			return null;
		}
		
      }
}		
