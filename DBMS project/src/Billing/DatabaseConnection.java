/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {
    public Connection connectToBilling(){
        String DB_URL = "jdbc:mysql://localhost:3306/billing";
        //  Database credentials
        String USER = "root";
        String PASS = "12345";
        Connection conn = null;
        //Statement stmt = null; 
            try{
              //STEP 2: Register JDBC driver
              Class.forName("com.mysql.jdbc.Driver");

              //STEP 3: Open a connection
              System.out.println("Connecting to database...");
              conn = DriverManager.getConnection(DB_URL,USER,PASS);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conn;
    }
    
//    public void disconnectDatabase(Connection conn){
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
