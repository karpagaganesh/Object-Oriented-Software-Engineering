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
class LineItems {
    LinkedList<OrderLineItem> lineitems = new LinkedList<OrderLineItem>();
    
    LinkedList<OrderLineItem> createItemList() {
        return new LinkedList<OrderLineItem>();
    }

    LinkedList<OrderLineItem> add(OrderLineItem item) {
        lineitems.add(item);
        return lineitems;
    }
    
}
