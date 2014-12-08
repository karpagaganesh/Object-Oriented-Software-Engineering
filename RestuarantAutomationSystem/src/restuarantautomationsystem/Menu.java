/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restuarantautomationsystem;

import java.util.ArrayList;

/**
 *
 * @author karpagaganeshpatchirajan
 */
class Menu {

    public ArrayList<String> getCategorySelectionDisplay() {
        Controller controller = new Controller();
        ArrayList<String> categories = controller.getMenuCategories();
        return categories;
    }
    
}
