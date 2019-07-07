package jewelleryUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DbConnection;
import Java.Category;

public class IdtoNameUtil 
{
	private Category category;
  public static String getcategoryName(int cID)
  {  String catName ="";
	  try {
			String query="SELECT * FROM category where CatId="+cID;
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs=tm.executeQuery(query);
			while(rs.next())
			{
				catName=rs.getString(2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return catName;
	  
  }
  
  public static String getcarat(int uID)
  {  
  String carat ="";
	  try {
			String query="SELECT * FROM unit where UnitId="+uID;
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs=tm.executeQuery(query);
			while(rs.next())
			{
				carat=rs.getString(2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return carat;
	  
  }
  
  
  public static String getproductname(int pID)
  {  
  String pname ="";
	  try {
			String query="SELECT * FROM product where ProductId="+pID;
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs=tm.executeQuery(query);
			while(rs.next())
			{
				pname=rs.getString(2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return pname;
	  
  }
  
  public static String getmodelname(int mID)
  {  
  String mname ="";
	  try {
			String query="SELECT * FROM model where ModelId="+mID;
			Statement tm =DbConnection.getconnection().createStatement();
			ResultSet rs=tm.executeQuery(query);
			while(rs.next())
			{
				mname=rs.getString(3);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return mname;
	  
  }
}
