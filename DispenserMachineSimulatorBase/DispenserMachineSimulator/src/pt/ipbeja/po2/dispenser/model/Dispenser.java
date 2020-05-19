package pt.ipbeja.po2.dispenser.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DiogoPM
 * @version 23/04/2019
 */

public class Dispenser {

    // array com as moedas válidas
    private static final int[] validCurrency = {5, 10, 20, 50};

    private List<Product> products;
    private int productStock = 10;
    private MoneyBox moneyBox;
    private Register register;

    public Dispenser(int productPrice, Register register) {
        // vamos utilizar o método que já valida o productPrice
        // se não for válido fica com o valor por defeito (40)

        this.moneyBox = new MoneyBox(validCurrency);
        this.register = register;
        this.moneyBox.setProductPrice(productPrice);

        this.products = new ArrayList<>();
    }

    /**
     * Inserts a coin
     *
     * @param coin The coin value
     * @return The total inserted amount so far
     */
    public int insertCoin(int coin) {

        return this.moneyBox.insertCoin(coin);
    }

    /**
     * Validate coin
     *
     * @param coin Coin to validate
     * @return True if coin is valid, false otherwise
     */
    private boolean isCoinValid(int coin) {
        for (int validCoin : validCurrency) {
            if (coin == validCoin) return true;
        }
        return false;
    }

    /**
     * Attempt to purchase a product
     *
     * @return 0 (zero) or positive amount (change) if the money inserted was sufficient to buy the products.
     * A negative amount means how much more money is necessary for a purchase and no products were dispensed.
     */
    public int buyProduct() {
        int difference = this.moneyBox.getDifference();
        // só podemos efetuar a venda se houver dinheiro suficiente
        // também só poderemos fazer a vendas se houver produtos!
        // TODO criar um teste para essa situação e depois implementar código para que o passe
        if (difference >= 0) {
            makeSale(difference);
        }
        return difference;
    }


    /**
     * Performs a sale
     */
    private void makeSale(int change) {
        this.moneyBox.makeSale(change);
        this.productStock--; // e retirar a quantidade vendida do stock
    }

    public int getProductStock() {
        return productStock;
    }

    public int getSalesMoney() {
        return this.moneyBox.getSalesMoney();
    }

    public int cancel() {
        return this.moneyBox.cancel();
    }

    public String getModel() {
        return this.register.getModel();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

}


















