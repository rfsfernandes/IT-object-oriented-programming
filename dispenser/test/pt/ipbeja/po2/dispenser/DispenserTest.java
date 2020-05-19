package pt.ipbeja.po2.dispenser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispenserTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void insertCoin() {
        Dispenser dispenser = new Dispenser(40);

        int insertedMoney = dispenser.insertCoin(10);

        assertEquals(10,insertedMoney);

        insertedMoney = dispenser.insertCoin(50);
        assertEquals(60,insertedMoney);

    }

    @Test
    void cancel() {
        Dispenser dispenser = new Dispenser(40);

        int numberOfProductsBefore = dispenser.getnProducts();

        int valueBefore = dispenser.getSalesMoney();
        dispenser.insertCoin(10);
        dispenser.insertCoin(20);

        assertEquals(dispenser.cancel(), 30);

        assertEquals(numberOfProductsBefore, dispenser.getnProducts());
        assertEquals(valueBefore, dispenser.getSalesMoney());

    }

    @Test
    void change() {
        Dispenser dispenser = new Dispenser(40);

        dispenser.insertCoin(70);
        int numbOfProducts = dispenser.getnProducts();
        int change = dispenser.buyProduct();
        int numberOfProductsAfter = numbOfProducts -1;
        assertEquals(change, 30);
        assertEquals(numberOfProductsAfter, dispenser.getnProducts());
        assertEquals(dispenser.getSalesMoney(),40);

    }

    @Test
    void changeUnsuficientFunds() {
        Dispenser dispenser = new Dispenser(40);

        dispenser.insertCoin(25);
        int retained = dispenser.getSalesMoney();
        int numbOfProducts = dispenser.getnProducts();
        int change = dispenser.buyProduct();
        int numberOfProductsAfter = dispenser.getnProducts();
        int retainedAfter = dispenser.getSalesMoney();

        assertEquals(change, 25 - 40);
        assertEquals(numbOfProducts, numberOfProductsAfter);
        assertEquals(dispenser.getSalesMoney(),25);
        assertEquals(retained, retainedAfter);
    }

}