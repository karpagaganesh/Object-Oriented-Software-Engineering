/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class Order {
    int orderID;
    String tableID;
    private Hashtable<Integer, LinkedList<OrderLineItem>> ordemap;
    
    
    LinkedList<OrderLineItem> createNewOrder(String tableID) {
        LineItems lineItem = new LineItems();
        LinkedList<OrderLineItem> orderline = lineItem.createItemList(); 
        Controller orderCont = new Controller();
        orderID = orderCont.createOrderTableEntry(tableID);
        
        return orderline;
    }

    LinkedList<OrderLineItem> makeItem(int itemID, int quantity, String desc) {
        OrderLineItem orderlineitem = new OrderLineItem();
        OrderLineItem item = orderlineitem.create(itemID,quantity,desc);
        LineItems lineitem = new LineItems();
        LinkedList<OrderLineItem> orderline  = lineitem.add(item);
        return orderline;
    }

   

    

}
