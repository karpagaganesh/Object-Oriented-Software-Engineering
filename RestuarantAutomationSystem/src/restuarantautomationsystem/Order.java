/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class Order {

    LinkedList createNewOrder(int tableID) {
        LineItems lineItem = new LineItems();
        LinkedList orderList = (LinkedList) lineItem.createItemList();
        return orderList;
    }

    
    
}
