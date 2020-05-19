package pt.ipbeja.po2.dispenser.model.products;

import java.util.List;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 13/05/2020 @ 11:13
 * For the project: DispenserMachineSimulator-Base-GP6
 */

public class Song extends CD{
    private String title;
    private int time;


    public Song(String name, int price, int duration, List<Author> authors, String title, int time) {
        super(name, price, duration, authors);
        this.title = title;
        this.time = time;
    }
}
