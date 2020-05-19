package pt.ipbeja;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testingTreeSet() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Cenas", LocalDate.of(2020, 2, 26)));
        personList.add(new Person("Cenas", LocalDate.of(2020, 3, 20)));
        personList.add(new Person("Cenas", LocalDate.of(2020, 1, 10)));
        personList.add(new Person("Cenas", LocalDate.of(2020, 4, 2)));
        personList.add(new Person("Cenas", LocalDate.of(2020, 2, 20)));
        personList.add(new Person("Cenas", LocalDate.of(2020, 2, 7)));

        TreeSet<Person> personTreeSet = new TreeSet<>(personList);
        personList.sort(Person::compareTo);

        assertEquals(personTreeSet.toString(), personList.toString());
        System.out.println(personList.toString());
        System.out.println(personTreeSet.toString());

    }

    @Test
    void testCompare() {
        List<Person> personList = Arrays.asList(new Person("Maria", LocalDate.of(2000, 10, 2)),
                new Person("Manuel", LocalDate.of(1980, 1, 3)),
                new Person("Isabel", LocalDate.of(1980, 1, 3)),
                new Person("Antonio", LocalDate.of(1992, 2, 4)));

        TreeSet<Person> orderedSetOfPersons = new TreeSet<>(personList);

        for(Person p : orderedSetOfPersons) {
            System.out.println(p);
        }

        List<Person>  orderedList = new ArrayList<>(orderedSetOfPersons);
        Comparator<Person> naturalOrderComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.compareTo(p2);
            }
        };

        List<Person> otherOrderedList = new ArrayList<>(personList);
        otherOrderedList.sort(naturalOrderComparator);

        assertEquals(orderedList.size(), otherOrderedList.size());
        assertEquals(orderedList, otherOrderedList);

    }

}