package pt.ipbeja.po2.dispenser.model;

import org.junit.jupiter.api.Test;
import pt.ipbeja.po2.dispenser.model.products.Author;
import pt.ipbeja.po2.dispenser.model.products.CD;
import pt.ipbeja.po2.dispenser.model.products.Camera;
import pt.ipbeja.po2.dispenser.model.products.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DiogoPM
 * @version 02/05/2019
 */

class ProductTest {

    @Test
    void productListTest() {

        List<Product> productList = new ArrayList<>();
        Product p = new Camera("Bolachas", 50);
        productList.add(p);

        Product savedProduct = productList.get(0);
        assertEquals("Bolachas", savedProduct.getName());
        assertEquals(50, savedProduct.getPrice());
        assertEquals(p, savedProduct);

        Product copy = new Camera("Bolachas", 50);
        assertEquals(p, copy);
        assertTrue(productList.contains(copy));

    }

    @Test
    void testingTaxes(){
        CD cd = new CD("CD teste", 20, 7199, new ArrayList<>());

        double taxes = ((int)(cd.getDuration() / 3600)) * 0.1;

        System.out.println(taxes);
        //assertEquals(0, taxes);

    }

}