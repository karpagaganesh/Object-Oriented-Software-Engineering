/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author karpagaganeshpatchirajan
 */
class OrderQueue {

    boolean addToQueue(Hashtable<Integer, LinkedList<OrderLineItem>> order) {
        
        Controller controller = new Controller();
        controller.updateOrderQueue(order);
        return true;
    }
    
}
