/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.util.LinkedList;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class Table {

    String tableID="";
    int orderID;
    boolean updateTableStatus(String status) {
        Controller controller = new Controller();
        return controller.updateTableStatus(status,this.tableID);
    }

    void setCurrentOrder(int orderID) {
        this.orderID = orderID;
        Controller controller = new Controller();
        controller.updateOrderIDinRestaurantTable(tableID,orderID);
    }
    
}
