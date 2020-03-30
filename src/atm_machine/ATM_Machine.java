/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_machine;

/**
 *
 * @author Ibro Yusuf Ola
 */
import java.sql.*;
public class ATM_Machine {

    /**
     * @param args the command line arguments
     */
    
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=Bank_Info;integratedSecurity=true";
    
     public static Connection getConnection() throws SQLException, ClassNotFoundException{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection con = DriverManager.getConnection(URL);
    if (con != null){
        System.out.println("Connection Successful");
    } else{
        System.out.println("Connection UnSuccessful");
    }
    return con;
    }
     
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        
        getConnection();
    }
    
}
