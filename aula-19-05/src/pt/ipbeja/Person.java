package pt.ipbeja;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 19/05/2020 @ 11:58
 * For the project: aula-19-05
 */

public class Person implements Comparable<Person>{
    private String name;
    private LocalDate birthdate;

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthdate, person.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate);
    }

    @Override
    public int compareTo(Person o) {
        if(getBirthdate().equals(o.getBirthdate())){
            return getName().compareTo(o.getName());
        }else{
            return getBirthdate().compareTo(o.getBirthdate());
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
