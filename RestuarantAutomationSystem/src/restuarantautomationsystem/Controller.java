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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class Controller {

    public static ArrayList<String> getEmployeeList() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        String query ="SELECT * from employee where role=\"waiter\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static ArrayList<String> getTableList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        String query ="SELECT * from restauranttables where tablestatus=\"Available\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static boolean assignTable(String tableID, String employeeID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="UPDATE restauranttables SET empID=\""+employeeID+"\",TableStatus=\"WaiterAssigned\" WHERE tableID=\""+tableID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);
            return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
      
    }

    public static ArrayList<String> getTableList(String empID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        String query ="SELECT * from restauranttables where empID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static void updateEmployeeWithTable(String empID, String tableID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="UPDATE employee SET assignedTable=\""+tableID+"\" WHERE employeeID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);  
        } 
        
      
    }

    public static String getEmployeeName(String empID) {
       try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result = "";
        String query ="SELECT * from employee where employeeID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result; 
    }

    public static ArrayList<String> getMenuItems(Object selectedValue) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        String query ="SELECT * from MenuItem where Category=\""+(String)selectedValue+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static ArrayList<String> getOrderQueueList() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        //String query ="SELECT OrderQueue.idOrderQueue, MenuItem.Item,OrderQueue.Quantity\n" +
        String query ="SELECT MenuItem.Item\n" +
                        "FROM MenuItem\n" +
                        "INNER JOIN OrderQueue\n" +
                        "ON MenuItem.ItemID=OrderQueue.ItemID\n" +
                        "WHERE OrderQueue.Status=\"Ordered\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static ArrayList<String> getOrderQueueStatus() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        //String query ="SELECT OrderQueue.idOrderQueue, MenuItem.Item,OrderQueue.Status\n" +
        String query ="SELECT OrderQueue.Status\n" +
                        "FROM MenuItem\n" +
                        "INNER JOIN OrderQueue\n" +
                        "ON MenuItem.ItemID=OrderQueue.ItemID\n" +
                        "WHERE OrderQueue.Status=\"Ordered\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public static ArrayList<String> getOrderQuantity() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        //String query ="SELECT OrderQueue.idOrderQueue, MenuItem.Item,OrderQueue.Status\n" +
        String query ="SELECT OrderQueue.Quantity\n" +
                        "FROM MenuItem\n" +
                        "INNER JOIN OrderQueue\n" +
                        "ON MenuItem.ItemID=OrderQueue.ItemID\n" +
                        "WHERE OrderQueue.Status=\"Ordered\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }
    
    public  String getAssignedTableFromEmployeeTable(String empID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result = "";
        String query ="SELECT * from employee where employeeID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getString(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public String EnterCredentials(String empID, String password) {
        
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="SELECT * from employee where employeeID=\""+empID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                if(rs.getString(1).equalsIgnoreCase(password)){
                   
                    return rs.getString(2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    

    public boolean changeTableStatus(String status,String tableID) {
        Table table = new Table();
        table.tableID = tableID;
        return table.updateTableStatus(status);
    }

    public Hashtable<Integer,LinkedList<OrderLineItem>> makeNewOrder(String tableID) {
        Order order = new Order();
        LinkedList<OrderLineItem> orderline = order.createNewOrder(tableID);
        
        Table table = new Table();
        table.tableID = tableID;
        table.setCurrentOrder(order.orderID);
        
        Hashtable<Integer,LinkedList<OrderLineItem>> ordermap = new Hashtable<Integer,LinkedList<OrderLineItem>>();
        ordermap.put(order.orderID, orderline);
        return ordermap;
    }

    boolean updateTableStatus(String status,String tableID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="UPDATE restauranttables SET TableStatus=\""+status+"\" WHERE tableID=\""+tableID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);
            return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    int createOrderTableEntry(String tableID) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result = "";
        int orderID = 1;
        String query ="SELECT max(orderid) from OrderEntry;";
                //"SELECT * from order;";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while(rs.next()){
                orderID = 1+Integer.parseInt(rs.getString(1));
            }
            query = "INSERT INTO OrderEntry (OrderID, TableID, OrderList) VALUES ("+orderID+",\""+tableID+"\",\"\");";
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return orderID;
        
    }

    void updateOrderIDinRestaurantTable(String tableID, int orderID) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String query ="UPDATE restauranttables SET orderID=\""+orderID+"\" WHERE tableID=\""+tableID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            stmt.executeUpdate(query);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
    }

    public ArrayList<String> addNewItemButton() {
        
        Menu menu =new Menu();
        return menu.getCategorySelectionDisplay();
    }

    public ArrayList<String> getMenuCategories() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> result = new ArrayList<String>();
        String query ="SELECT * from MenuCategories;";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result.add(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public String getMenuItemDescription(Object categorySelected, Object itemSelected) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result="";
        String query ="SELECT Description from MenuItem where Category=\""+(String)categorySelected+"\" AND Item=\""+(String)itemSelected+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            System.out.println("dsfsfs");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public int getItemID(Object categorySelected, Object itemSelected) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        int result=-1;
        String query ="SELECT ItemID from MenuItem where Category=\""+(String)categorySelected+"\" AND Item=\""+(String)itemSelected+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result = Integer.parseInt(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public Hashtable<Integer,LinkedList<OrderLineItem>> addItemToOrderLine(int itemID, int quantity,Hashtable<Integer,LinkedList<OrderLineItem>> ordermap) {
        Categories categoryObj = new Categories();
        String desc = categoryObj.getItemDescription(itemID);
        Order orderObj = new Order();
        LinkedList<OrderLineItem> orderline = orderObj.makeItem(itemID,quantity,desc);
        Set s = ordermap.entrySet();
        Iterator it = s.iterator();
        if(it.hasNext()){
            Map.Entry<Integer,LinkedList<OrderLineItem>> m = (Entry<Integer,LinkedList<OrderLineItem>>)it.next();
            int OrderID = (Integer)m.getKey();
            LinkedList<OrderLineItem> exitstingOrderLineItem = (LinkedList<OrderLineItem>) m.getValue();
            for(OrderLineItem x:orderline){
                exitstingOrderLineItem.addLast(x);
            }
            ordermap.put(OrderID, exitstingOrderLineItem);
        }
        
        return ordermap;
        
    }

    String getItemDescription(int itemID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String DBURL = "jdbc:mysql://localhost:3306/restaurant";
        String username ="root";
        String pass = "root";
            
        Connection dbCon = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result="";
        String query ="SELECT Description from MenuItem where ItemID=\""+itemID+"\";";
        try {
            
            dbCon = DriverManager.getConnection(DBURL, username,pass);
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            
            while(rs.next()){
                result = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }

    public boolean submitOrderToOrderQueue(Hashtable<Integer, LinkedList<OrderLineItem>> order) {
        
        OrderQueue queue = new OrderQueue();
        boolean flagOrder = queue.addToQueue(order);
        return flagOrder;
        
    }

    void updateOrderQueue(Hashtable<Integer, LinkedList<OrderLineItem>> order) {
        Set s =order.entrySet();
        Iterator it = s.iterator();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                String DBURL = "jdbc:mysql://localhost:3306/restaurant";
                String username ="root";
                String pass = "root";
            
                Connection dbCon = null;
                Statement stmt = null;
                ResultSet rs = null;
                int result=0;
                String query ="SELECT max(ID) from OrderQueue;";
                try {
                    dbCon = DriverManager.getConnection(DBURL, username,pass);
                    stmt = dbCon.prepareStatement(query);
                    rs = stmt.executeQuery(query);
            
                    while(rs.next()){
                        result = Integer.parseInt(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                if(it.hasNext()){
                    Map.Entry<Integer,LinkedList<OrderLineItem>> m = (Entry<Integer,LinkedList<OrderLineItem>>) it.next();
                    int OrderID = (Integer) m.getKey();
                    LinkedList<OrderLineItem> value = m.getValue();
                    for(OrderLineItem o:value){
                        int itemID = (Integer)o.itemID;
                        int quantity = (Integer)o.quantity;

                        result++;
                        try {

                            query = "INSERT INTO OrderQueue (ID,idOrderQueue, ItemID, Quantity,Status) VALUES ("+result+","+OrderID+","+itemID+","+quantity+",\"Ordered\");";
                            stmt = dbCon.prepareStatement(query);
                            stmt.executeUpdate(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                }
    }

    
    
    
    
}
