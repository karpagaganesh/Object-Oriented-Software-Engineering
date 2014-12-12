/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

/**
 *
 * @author karpagaganeshpatchirajan
 */
public class OrderLineItem {
    public int itemID;
    public int quantity;
    OrderLineItem create(int itemID, int quantity, String desc) {
        OrderLineItem item = new OrderLineItem();
        item.itemID = itemID;
        item.quantity = quantity;
        return item;
    }
    
}
