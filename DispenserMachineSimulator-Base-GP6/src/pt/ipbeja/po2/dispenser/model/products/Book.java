package pt.ipbeja.po2.dispenser.model.products;

import java.util.List;
import java.util.Objects;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 10:55
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class Book extends ProductWithAuthors {
    private String publisher;
    private List<Author> authors;

    public Book(String name, int price, String publisher, List<Author> authors) {
        super(name, price);
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public int computeTax() {
        return (int) (getPrice() * 0.10);
    }

    @Override
    public int priceWithTax() {
        return getPrice() + computeTax();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(publisher, book.publisher) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publisher, authors);
    }
}
