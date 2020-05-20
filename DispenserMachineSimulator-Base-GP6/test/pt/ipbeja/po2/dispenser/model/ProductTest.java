package pt.ipbeja.po2.dispenser.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipbeja.po2.dispenser.model.products.*;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DiogoPM
 * @version 02/05/2019
 */

class ProductTest {

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

    @Test
    void testingOrder(){
        List<Product> productList = this.dispenser.getProducts();

        TreeSet<Product> productTreeSet = new TreeSet<Product>(this.dispenser.getProducts());
        
        System.out.println("List:" + productList.toString() + "\n");
        System.out.println("TreeSet" + productTreeSet.toString() + "\n");
        productList.sort(Product::compareTo);

        assertEquals(productList.toString(), productTreeSet.toString());
    }

}