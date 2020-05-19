package pt.ipbeja.po2.dispenser.model.products;

import java.util.List;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 11:12
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class CD extends Disc{
    public CD(String name, int price, int duration, List<Author> authors) {
        super(name, price, duration, authors);
    }

    @Override
    public int computeTax() {
        double taxes = ((int)(getDuration() / 3600)) * 0.1 ;

        return (int) (getPrice() * taxes);
    }

    @Override
    public int priceWithTax() {
        return getPrice() + computeTax();
    }
}
