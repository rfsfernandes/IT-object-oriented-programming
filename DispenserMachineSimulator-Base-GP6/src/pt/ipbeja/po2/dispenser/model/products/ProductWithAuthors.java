package pt.ipbeja.po2.dispenser.model.products;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 11:07
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public abstract class ProductWithAuthors extends Product {
    public ProductWithAuthors(String name, int price) {
        super(name, price);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
