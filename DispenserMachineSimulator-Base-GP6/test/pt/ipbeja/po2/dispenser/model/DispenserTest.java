package pt.ipbeja.po2.dispenser.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipbeja.po2.dispenser.model.products.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DiogoPM
 * @version 23/04/2019
 */

class DispenserTest {
    private Product p1, p2, p3;
    private List<Author> authors;
    private Dispenser dispenser;

    @BeforeEach
    public void setUp(){
        this.dispenser = new Dispenser(new Register("Aquele dispenser do dragão", "Snax", 2020));
        this.authors = Arrays.asList(
                new Author("Rodrigo", "Portugal"),
                new Author("João", "Portugal"),
                new Author("António", "Portugal"));
        this.p1 = new Book("Livro do dragão", 20, "Editana", this.authors);
        this.p2 = new CD("Yo yo yo", 15, 3630, this.authors);
        this.p3 = new Camera("Canon 70D", 700);

        this.dispenser.addProduct(this.p1);
        this.dispenser.addProduct(this.p2);
        this.dispenser.addProduct(this.p3);
    }


    @Test
    void testInsertCoin() {

        //Dispenser dispenser = new Dispenser(40);

        // insertCoin devolve a quantidade inserida até ao momento
        int balance = dispenser.insertCoin(20);
        // verificamos que de facto a máquina aceitou os 20
        assertEquals(20, balance);

        // quando inserimos mais 10
        balance = dispenser.insertCoin(10);
        // verificamos que a máquina agora tem 30
        assertEquals(30, balance);

    }

    @Test
    void testCancelPurchase() {
        //Dispenser dispenser = new Dispenser(40);

        dispenser.insertCoin(20);
        int balance = dispenser.insertCoin(10);

        // Quantidades *antes* de cancelar para podermos ver se mudaram
        int productCount = dispenser.getProductStock();
        int salesMoney = dispenser.getSalesMoney();

        // Cancelamos a compra
        int dispensedMoney = dispenser.cancel();

        // Comparamos as quantidades antes e *depois* de cancelar
        assertEquals(balance, dispensedMoney);
        assertEquals(productCount, dispenser.getProductStock());
        assertEquals(salesMoney, dispenser.getSalesMoney());

        balance = dispenser.insertCoin(10);
        dispensedMoney = dispenser.cancel();
        assertEquals(balance, dispensedMoney);
    }

    @Test
    void testBuyProduct() {
        //Dispenser dispenser = new Dispenser(40);

        // quantidades antes de comprar
        int productsBefore = dispenser.getProductStock();
        int salesBefore = dispenser.getSalesMoney();

        dispenser.insertCoin(50);
        dispenser.selectProduct("Yo yo yo");
        int change = dispenser.buyProduct();

        // comparar antes com depois de comprar
        assertEquals(salesBefore + 15, dispenser.getSalesMoney());
        assertEquals(productsBefore - 1, dispenser.getProductStock());
        assertEquals(35, change);

        dispenser.insertCoin(10);
        dispenser.insertCoin(10);
        dispenser.insertCoin(10);
        dispenser.selectProduct(0); // camera, 700
        change = dispenser.buyProduct();
        assertEquals(10, change);

    }


    /**
     * Este teste não aparece no GP.
     * Visa testar que a máquina só aceita moedas válidas (5, 10, 20, 50)
     */
    @Test
    void testInsertInvalidCoins() {
        //Dispenser dispenser = new Dispenser(40);

        dispenser.insertCoin(20); // esta moeda é válida

        int balance = dispenser.insertCoin(7); // moeda inválida

        // verificamos que a máquina não aceitou a moeda e o balance manteve-se igual
        assertEquals(20, balance);

        // mais uns testes com moedas inválidas
        balance = dispenser.insertCoin(100);
        assertEquals(20, balance);
        balance = dispenser.insertCoin(24);
        assertEquals(20, balance);
    }

    @Test
    void testBuyProductInsufficientMoney() {
        //Dispenser dispenser = new Dispenser(40);
        dispenser.insertCoin(10);
        dispenser.insertCoin(5);

        // quantidades antes de tentar comprar
        int products = dispenser.getProductStock();
        int salesMoney = dispenser.getSalesMoney();

        // quando buyProduct é invocado com uma quantidade de dinheiro insuficiente
        // devolve o dinheiro em falta
        dispenser.selectProduct(0);
        int missing = dispenser.buyProduct();

        // verificamos que de facto faltam 5 para comprar o produto
        assertEquals(-5, missing);

        // e que não foi vendido qualquer produto
        assertEquals(products, dispenser.getProductStock());
        assertEquals(salesMoney, dispenser.getSalesMoney());
    }

    @Test
    void testRegisterInformation() {

        assertEquals("Aquele dispenser do dragão", dispenser.getModel());
        assertEquals("Snax", dispenser.getCompany());
        assertEquals(2020, dispenser.getYear());

    }

    @Test
    void getMostExpensiveTest() {
        Product expected = new Camera("Canon 70D", 700);
        Product expensive = dispenser.getMostExpensiveProduct();
        assertEquals(expected, expensive);
    }

    @Test
    void getCheapestTest() {
        Product expected = new CD("Yo yo yo", 15, 3630, this.authors);
        Product cheapest = dispenser.getCheapestProduct();
        assertEquals(expected, cheapest);
    }

    @Test
    void getAveragePriceTest() {
        double avg = dispenser.getAveragePrice();
        double expected = 735 / 3.0;
        assertEquals(avg, expected);

    }

    @Test
    void getProductNamesTest() {
        String names = dispenser.getProductNames();

        assertEquals("Livro do dragão\nYo yo yo\nCanon 70D\n", names);
    }

    @Test
    void getProductsCheaperThanTest() {

        List<Product> expected = Arrays.asList(new Book("Livro do dragão", 20, "Editana", this.authors), new CD("Yo yo yo", 15, 3630, this.authors));
        List<Product> cheaper = dispenser.getProductsCheaperThan(21);
        assertEquals(expected.toString(), cheaper.toString());

    }


    @Test
    void testingTax(){
        for (Product product : this.dispenser.getProducts()){

            assertEquals(product.priceWithTax(),product.getPrice() + product.computeTax() );
        }
    }

}



















