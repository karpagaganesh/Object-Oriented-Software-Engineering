/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class Controller {

    public boolean EnterCredentials(String empID, String password) {
        
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/Test";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="SELECT * from TestTable where ID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(password)){
                   
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    

    public boolean changeTableStatus(int status) {
        Table table = new Table();
        return table.updateTableStatus(status);
    }

    public void makeNewOrder(int tableID) {
        Order order = new Order();
        LinkedList orderList = order.createNewOrder(tableID);
        Table table = new Table();
        table.setCurrentOrder(orderList);
    }
    
    
    
}
