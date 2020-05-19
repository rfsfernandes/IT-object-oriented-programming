package pt.ipbeja;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void test1(){
        List<String> numberList = new ArrayList<>();

        numberList.add("966666666");
        numberList.add("9655555555");

        Contact contact = new Contact("Rodrigo",numberList);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(contact);
        Phone phone = new Phone(contactList);

        assertEquals(2, phone.getContactList().get(0).getPhoneList().size());


    }

    @Test
    void test2(){

        List<String> numberList = new ArrayList<>();

        numberList.add("966666666");
        numberList.add("9655555555");

        Contact contact = new Contact("Rodrigo",numberList);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(contact);

        Map<String, List<Contact>> mapContacts = new HashMap<>();
        mapContacts.put(contact.getName(), contactList);

        Phone phone = new Phone(contactList);
        phone.setMapContacts(mapContacts);

        assertEquals(2, phone.getMapContacts().get("Rodrigo").get(0).getPhoneList().size());

        System.out.println(phone.getMapContacts().get("Rodrigo").get(0).getPhoneList().size());

    }

    @Test
    void test3(){


    }


}