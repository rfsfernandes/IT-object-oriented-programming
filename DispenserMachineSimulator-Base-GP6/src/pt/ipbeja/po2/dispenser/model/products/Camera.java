package pt.ipbeja.po2.dispenser.model.products;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 11:13
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class Camera extends Product{
    public Camera(String name, int price) {
        super(name, price);
    }

    @Override
    public int computeTax() {
        return (int) (getPrice() * 0.20);
    }

    @Override
    public int priceWithTax() {
        return getPrice() + computeTax();
    }
}
