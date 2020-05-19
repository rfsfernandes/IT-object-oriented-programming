package pt.ipbeja.po2.dispenser.model;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 29/04/2020 @ 10:52
 * For the project: DispenserMachineSimulator
 */

public class MoneyBox {

    private int productPrice = 40;
    private int insertedMoney = 0;
    private int salesMoney = 0;
    private int[] validCurrency;

    public MoneyBox(int [] validCurrency) {
        this.validCurrency = validCurrency;
    }

    /**
     * Inserts a coin
     * @param coin The coin value
     * @return The total inserted amount so far
     */
    public int insertCoin(int coin) {
        // só deixamos inserir a moeda se esta for válida
        if(isCoinValid(coin)) {
            this.insertedMoney += coin;
        }
        return this.insertedMoney;
    }

    /**
     * Validate coin
     * @param coin Coin to validate
     * @return True if coin is valid, false otherwise
     */
    private boolean isCoinValid(int coin) {
        for (int validCoin : validCurrency) {
            if(coin == validCoin) return true;
        }
        return false;
    }

    /**
     * Attempt to purchase a product
     * @return 0 (zero) or positive amount (change) if the money inserted was sufficient to buy the products.
     * A negative amount means how much more money is necessary for a purchase and no products were dispensed.
     */
    public int buyProduct() {
        int difference = getDifference();
        // só podemos efetuar a venda se houver dinheiro suficiente
        // também só poderemos fazer a vendas se houver produtos!
        // TODO criar um teste para essa situação e depois implementar código para que o passe
        if(difference >= 0) {
            makeSale(difference);
        }
        return difference;
    }

    /**
     * Calculates the difference between the amount of money inserted and
     * the total price of the purchase. 0 or positive if enough money, negative otherwise
     * @return The difference
     */
    public int getDifference() {
        return this.insertedMoney - productPrice;
    }

    /**
     * Cancels the current operation and returns the inserted money
     * @return The inserted money
     */
    public int cancel() {
        int temp = this.insertedMoney;
        this.insertedMoney = 0;
        return temp;
    }

    public int getSalesMoney() {
        return salesMoney;
    }

    public void makeSale(int change) {
        this.insertedMoney = 0;
        this.salesMoney += productPrice; // somar o dinheiro da venda
    }

    /**
     * Set the product price
     * @param productPrice An amount greater than zero and multiple of 10
     */
    public void setProductPrice(int productPrice) {
        if(productPrice > 0 && productPrice % 10 == 0) {
            this.productPrice = productPrice;
        }
    }

}
