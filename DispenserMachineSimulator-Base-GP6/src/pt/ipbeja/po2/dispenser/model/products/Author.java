package pt.ipbeja.po2.dispenser.model.products;

import java.util.Objects;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 10:56
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class Author {
    private String name;
    private String nationality;

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(nationality, author.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }
}
