package pt.ipbeja.po2.dispenser.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testCreateProduct(){
        Product product = new Product("Chocolate_50g", 100);
        assertEquals("Chocolate_50g", product.getName());
        assertEquals(100, product.getPrice());
    }

    @Test
    void testProductList(){
        List<Product> products = new ArrayList<Product>();

        products.add(new Product("Chocolate_50g", 100));
        products.add(new Product("M&M_10g", 120));


        assertEquals("Chocolate_50g", products.get(0).getName());
        assertEquals(100, products.get(0).getPrice());
        assertEquals("M&M_10g", products.get(1).getName());
        assertEquals(120, products.get(1).getPrice());

        assertEquals(new Product("M&M_10g", 120), products.get(1));

    }

}