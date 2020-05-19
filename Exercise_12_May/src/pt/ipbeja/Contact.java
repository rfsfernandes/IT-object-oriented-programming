package pt.ipbeja;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 12/05/2020 @ 15:13
 * For the project: Exercise_12_May
 */

public class Contact {
    private String name;
    private List<String> phoneList = new ArrayList<>();

    public Contact(String name, List<String> phoneList) {
        this.name = name;
        this.phoneList = phoneList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
}
