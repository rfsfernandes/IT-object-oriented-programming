package pt.ipbeja.po2.dispenser;

public class Dispenser {
    private int salesMoney = 0;
    private int insertedMoney = 0;
    private int nProducts = 5;
    private final int productPrice;

    public Dispenser(int productPrice) {
        this.productPrice = productPrice;
    }

    public int insertCoin(int coinValue) {
        this.insertedMoney += coinValue;
        this.salesMoney += coinValue;
        return this.salesMoney;
    }

    public int cancel(){
        this.salesMoney = 0;
        return this.insertedMoney;
    }

    public int getSalesMoney() {
        return this.salesMoney;
    }

    public int getProductPrice() {
        return this.productPrice;
    }

    public int getnProducts() {
        return nProducts;
    }

    public int buyProduct() {
        int change = this.insertedMoney - this.productPrice;

        if(change >= 0){
            this.salesMoney -= change;
            this.nProducts--;
        }

        return change;
    }
}
