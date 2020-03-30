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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ATM_Code {
    
        
    private static void pinChecker() throws SQLException {
        
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
    String accName;
    
        try {
            Scanner userPin = new Scanner(System.in);
            System.out.println("Input your four (4) digit pin.");
            int uPin = userPin.nextInt();
            
            con = ATM_Machine.getConnection();
            String sql = "select Account_Name from Account_Info where Account_Pin=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, uPin);
            rs = pst.executeQuery();
            
            if (rs.next()){
                accName = rs.getString("Account_Name");
                System.out.println("Pin Correct!");
                System.out.println("");
                System.out.println("Welcome " + accName);
            }else{
                System.out.println("Pin Incorrect");
                System.out.println("Please try again!");
                pinChecker();
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ATM_Code.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws SQLException{
        pinChecker();
    }    
}
