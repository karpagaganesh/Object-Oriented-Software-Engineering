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
class FoodItemDescription {

    String getDecription(int itemID) {
        Controller con = new Controller();
        return con.getItemDescription(itemID);
    }
    
}
