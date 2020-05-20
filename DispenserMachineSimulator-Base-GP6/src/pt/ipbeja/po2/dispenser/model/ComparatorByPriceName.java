package pt.ipbeja.po2.dispenser.model;

import pt.ipbeja.po2.dispenser.model.products.Product;

import java.util.Comparator;

/**
 * @author Rodrigo Fernandes, 17845
 * Date: 20/05/2020 @ 11:30
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class ComparatorByPriceName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int cn = o1.getName().compareTo(o2.getName());
        if(cn == 0){
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
        return cn;
    }
}
