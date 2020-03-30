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
        
    static String accName;
    static double accAmount;
    static int valPin;
    static Connection con;
    static ResultSet rs;
    static Statement st;
    static PreparedStatement pst;
    
    private static void pinChecker() throws SQLException {    
    
    
    
        try {
            Scanner userPin = new Scanner(System.in);
            System.out.println("Input your four (4) digit pin.");
            int uPin = userPin.nextInt();
            
            con = ATM_Machine.getConnection();
            String sql = "select Account_Name, Account_Amount from Account_Info where Account_Pin=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, uPin);
            rs = pst.executeQuery();
            
            if (rs.next()){
                valPin = uPin;
                accName = rs.getString("Account_Name");
                accAmount = rs.getDouble("Account_Amount");
                System.out.println("Pin Correct! \n");
                System.out.println("Welcome " + accName);
                System.out.println("N" + accAmount + "\n");
                
            }else{
                System.out.println("Pin Incorrect");
                System.out.println("Please try again!");
                pinChecker();
            }
            
            pst.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ATM_Code.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        pinChecker();
        userTrans();
    }    

    private static void userTrans() throws SQLException, ClassNotFoundException {
        Scanner choTrans = new Scanner(System.in);
        
        System.out.println("Press 1 for Withdrawals");
        System.out.println("Press 2 for Deposits");
        System.out.println("Press 3 for Change Pin");
        System.out.println("Press 4 to Cnacel Operation \n");
        System.out.print("Choose a Transaction: ");
        
        int selTrans = choTrans.nextInt();
        
        switch(selTrans){
            case 1: selWithdrawals();
                break;
            case 2: selDeposits();
                break;
            case 3: selChagPin();
                break;
            case 4: System.exit(0);
                break;
            default: System.out.println("Invalid Entry");
                    userTrans();
        }
    }

    private static void selWithdrawals() throws SQLException, ClassNotFoundException {
        Scanner choWitd = new Scanner(System.in);
        System.out.println("\nWithdrawal \n");
        
        System.out.println("Press 1 for N100");
        System.out.println("Press 2 for N200");
        System.out.println("Press 3 for N300");
        System.out.println("Press 4 for Others");
        System.out.println("Press 5 for Cancel \n");
        
        System.out.print("Your Option: ");
        
        int selWitd = choWitd.nextInt();
        
        switch(selWitd){
            case 1: optA();
                break;
            case 2: optB();
                break;
            case 3: optC();
                break;
            case 4: optD();
                break;
            case 5: userTrans();
                break;
            default: System.out.println("Invalid Input");
                    selWithdrawals();
        }
        
        double witdAmount = choWitd.nextDouble();
    }

    public static void optA() throws SQLException, ClassNotFoundException {
        Scanner coptA = new Scanner(System.in);
        
        if(accAmount < 100){
            System.out.println("Insufficient Funds!");
            System.out.println("Try again!");
            selWithdrawals();
        }else{
            double a = accAmount - 100.00;
            
            con = ATM_Machine.getConnection();
            String sql = "update Account_Info set Account_Amount=? where Account_Name=?;";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, a);
            pst.setString(2, accName);
            pst.executeUpdate();
            pst.close();
            con.close();
            
            System.out.println("\nNew Balance = N" + a + "\n");
        }
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = coptA.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
        
    }

    private static void optB() throws SQLException, ClassNotFoundException {
        Scanner coptB = new Scanner(System.in);
        
        if(accAmount < 200){
            System.out.println("Insufficient Funds!");
            System.out.println("Try again!");
            selWithdrawals();
        }else{
            double a = accAmount - 200.00;
            
            con = ATM_Machine.getConnection();
            String sql = "update Account_Info set Account_Amount=? where Account_Name=?;";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, a);
            pst.setString(2, accName);
            pst.executeUpdate();
            pst.close();
            con.close();
            
            System.out.println("\nNew Balance = N" + a + "\n");
        }
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = coptB.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
    }

    private static void optC() throws SQLException, ClassNotFoundException {
        Scanner coptC = new Scanner(System.in);
        
        if(accAmount < 300){
            System.out.println("Insufficient Funds!");
            System.out.println("Try again!");
            selWithdrawals();
        }else{
            double a = accAmount - 300.00;
            
            con = ATM_Machine.getConnection();
            String sql = "update Account_Info set Account_Amount=? where Account_Name=?;";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, a);
            pst.setString(2, accName);
            pst.executeUpdate();
            pst.close();
            con.close();
            
            System.out.println("\nNew Balance = N" + a + "\n");
        }
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = coptC.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
    }

    private static void optD() throws SQLException, ClassNotFoundException {
        Scanner coptD = new Scanner(System.in);
        
        System.out.print("Insert amount: ");
        double amo = coptD.nextInt();
        
        if(accAmount < amo){
            System.out.println("Insufficient Funds!");
            System.out.println("Try again!");
            selWithdrawals();
        }else{
            double a = accAmount - amo;
            
            con = ATM_Machine.getConnection();
            String sql = "update Account_Info set Account_Amount=? where Account_Name=?;";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, a);
            pst.setString(2, accName);
            pst.executeUpdate();
            pst.close();
            con.close();
            
            System.out.println("\nNew Balance = N" + a + "\n");
        }
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = coptD.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
    }

    private static void selDeposits() throws SQLException, ClassNotFoundException {
        Scanner choDepo = new Scanner(System.in);
        
        System.out.println("\nDeposit \n");
        System.out.print("Input amount to deposit: ");
        
        double damo = choDepo.nextInt();
        
        double a = accAmount + damo;
        
        con = ATM_Machine.getConnection();
        String sql = "update Account_Info set Account_Amount=? where Account_Name=?;";
        pst = con.prepareStatement(sql);
        pst.setDouble(1, a);
        pst.setString(2, accName);
        pst.executeUpdate();
        pst.close();
        con.close();

        System.out.println("Deposit Successful!");
        System.out.println("\nNew Balance = N" + a + "\n");
        
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = choDepo.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
    }

    private static void selChagPin() throws SQLException, ClassNotFoundException {
        Scanner choPin = new Scanner(System.in);
        
        System.out.println("\nChange Pin \n");
        System.out.print("Input new Pin: ");
        
        int inewpin = choPin.nextInt();
        
        con = ATM_Machine.getConnection();
        String sql = "update Account_Info set Account_Pin=? where Account_Name=?;";
        pst = con.prepareStatement(sql);
        pst.setInt(1, inewpin);
        pst.setString(2, accName);
        pst.executeUpdate();
        pst.close();
        con.close();
        
        System.out.println("\nChange of Pin: Successful! \n");
        
        System.out.println("Do you wanna perform another Transaction?");
        System.out.print("Input 1 for Yes and 2 for No: ");
        
        int perTrans = choPin.nextInt();
        
        if(perTrans == 1){
            userTrans();
        }else{
        System.out.println("Thanks for Banking with us :)");
        System.exit(0);
        }
    }
}
