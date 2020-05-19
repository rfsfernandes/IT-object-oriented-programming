package pt.ipbeja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 12/05/2020 @ 15:14
 * For the project: Exercise_12_May
 */

public class Phone {

    private List<Contact> contactList = new ArrayList<>();
    private Map<String, List<Contact>> mapContacts = new HashMap<>();
    private Map<String, String> nameToContact = new HashMap<>();

    public Phone(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Map<String, List<Contact>> getMapContacts() {
        return mapContacts;
    }

    public void setMapContacts(Map<String, List<Contact>> mapContacts) {
        this.mapContacts = mapContacts;
    }

    public Map<String, String> getNameToContact() {
        return nameToContact;
    }

    public void setNameToContact(Map<String, String> nameToContact) {
        this.nameToContact = nameToContact;
    }
}
