package Java.jasperreports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
 
    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "jewellery";
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);
    }
 
    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
 
        
        Class.forName("com.mysql.jdbc.Driver");
 
        
        String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
 
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        /*
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        
        //step2 create  the connection object  
        Connection conn=DriverManager.getConnection(  
        "jdbc:oracle:thin:@125.17.78.250:1521:campdev","Campuslib","campuslib");  
        */
        return conn;
    }
    
   
    
}