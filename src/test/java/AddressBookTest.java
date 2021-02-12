import Application.AddressBook;
import Application.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;

public class AddressBookTest {
    private AddressBook book;

    @Before
    public void set() throws Exception {
        book = new AddressBook();

        book.addBuddy(new BuddyInfo("Abdi", "123 See Street", "613-123-4567"));
        book.addBuddy(new BuddyInfo ("Joe", "81 Buckets Lane", "416-555-1234"));
    }


    @Test
    public void addBuddy() {
        book.addBuddy(new BuddyInfo("Na", "22 Dee Block", "819-345-6778"));
        assertEquals("Size of address book is 3", 3, 3);
    }

    @Test
    public void removeBuddy() {
        book.removeBuddy(0);
        book.removeBuddy(0);
        assertEquals("Size of address book is 1", 1, 1);
    }

    @Test
    public void clear() {
        book.clear();
        assertEquals("Size of address book is 0", 0, 0);
    }

}