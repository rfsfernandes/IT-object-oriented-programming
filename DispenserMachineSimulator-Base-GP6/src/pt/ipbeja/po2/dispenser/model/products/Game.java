package pt.ipbeja.po2.dispenser.model.products;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 11:20
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class Game extends Product {
    private String platform;

    public Game(String name, int price, String platform) {
        super(name, price);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public int computeTax() {
        return 0;
    }

    @Override
    public int priceWithTax() {
        return getPrice() + computeTax();
    }
}
