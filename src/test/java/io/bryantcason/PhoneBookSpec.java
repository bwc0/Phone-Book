package io.bryantcason;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PhoneBookSpec {

    PhoneBook newarkPhoneBook;
    ArrayList<String> numbers;

    @Before
    public void init() {
        numbers = new ArrayList<String>();
        newarkPhoneBook = new PhoneBook();
        numbers.add("4132");
        numbers.add("2321");
        numbers.add("4232");
        newarkPhoneBook.addContact("Jet Li", numbers);
        newarkPhoneBook.addContact("Jackie Chan", numbers);
        newarkPhoneBook.addContact("Bruce Lee", numbers);
    }

    @Test
    public void lookUpContactTest(){
        ArrayList<String> expectedValue = new ArrayList<String>();
        expectedValue.add("4132");
        expectedValue.add("2321");
        expectedValue.add("4232");
        ArrayList<String> actualValue = newarkPhoneBook.lookUpContact("Jet Li");
        assertEquals("Show the number for Jet Li", expectedValue, actualValue);
    }

    @Test
    public void listAllNamesTest(){
        String expectedValue = "Bruce Lee, Jackie Chan, Jet Li, ";
        String actualValue = newarkPhoneBook.listAllNames();
        assertEquals("Should list all names", expectedValue, actualValue);
    }

    @Test
    public void listAllContactsTest(){
        newarkPhoneBook.addContact("Jet Li", numbers);
        String expectedValue = "Bruce Lee, [4132, 2321, 4232], Jackie Chan, [4132, 2321, 4232], Jet Li, [4132, 2321, 4232], ";
        String actualValue = newarkPhoneBook.listAllContacts();
        assertEquals("Names and numbers should show", expectedValue, actualValue);
    }

    @Test
    public void removeContacts(){
        newarkPhoneBook.removeContact("Jet Li");
        ArrayList<String> actualValue = newarkPhoneBook.lookUpContact("Jet Li");
        assertNull("Should return null", actualValue);
        newarkPhoneBook.listAllContacts();
    }

    @Test
    public void reverseLookUpTest(){
        String expectedValue = "Bruce Lee";
        String actualValue = newarkPhoneBook.reverseLookUp("4132");
        assertEquals("Should return Bruce Lee", expectedValue, actualValue);
    }

}
