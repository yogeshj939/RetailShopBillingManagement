package Billing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataToDatabase {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        File file = new File("E:\\Education\\5th sem\\DBMS mini project\\products.txt");
        LineNumberReader lr = new LineNumberReader(new FileReader(file));
        String line = null;
        Connection conn = null;
        Statement stmt = null; 
        try{
              conn = new DatabaseConnection().connectToBilling();
                stmt = conn.createStatement();
                while((line = lr.readLine())!=null){
                String vals[] = line.split(",");
                String sql = "INSERT INTO `products` (`productID`, `productName`, `productCost`, "
                      + "`quantity`, `soldQuantity`, `supplierID`) VALUES ("+vals[0]+",\""+vals[1]+
                        "\","+vals[2]+","+vals[3]+","+vals[4]+","+vals[5]+")";
                stmt.executeUpdate(sql);
            }
        }
            catch (SQLException ex) {
                Logger.getLogger(DataToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}
