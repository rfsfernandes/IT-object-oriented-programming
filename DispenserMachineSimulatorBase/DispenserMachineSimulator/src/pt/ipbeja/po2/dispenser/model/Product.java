package pt.ipbeja.po2.dispenser.model;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 29/04/2020 @ 11:41
 * For the project: DispenserMachineSimulator
 */

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Product)) {
            return false;
        } else {
            Product p = ( Product ) obj ;
            return this.getPrice() == p.getPrice() && this.getName().equals(p.getName()) ;

        }
    }

}
