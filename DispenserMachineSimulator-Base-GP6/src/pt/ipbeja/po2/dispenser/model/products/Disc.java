package pt.ipbeja.po2.dispenser.model.products;

import java.util.List;
import java.util.Objects;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 10:56
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public abstract class Disc extends ProductWithAuthors {
    private int duration;
    private List<Author> authors;

    public Disc(String name, int price, int duration, List<Author> authors) {
        super(name, price);
        this.duration = duration;
        this.authors = authors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public int computeTax() {
        double taxes = ((int)(getDuration() / 3600)) * 0.1 ;

        return (int) (getPrice() * taxes);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disc)) return false;
        if (!super.equals(o)) return false;
        Disc disc = (Disc) o;
        return duration == disc.duration &&
                Objects.equals(authors, disc.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, authors);
    }
}
