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
public class Controller {

    public boolean EnterCredentials(String empID, String password) {
        
        if(empID == "test" && password == "test"){
            return true;
        }
        if(empID == "host" && password == "host"){
                
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
