import Application.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;


public class BuddyInfoTest {
    private BuddyInfo buddy;
    private String name;
    private String address;
    private String number;


    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Abdi", "123 Application.Main Street", "613-123-4567");
        name = "Abdi";
        number = "613-123-4567";
        address = "123 Application.MWain Street";
    }

    @Test
    public void setNameGetName() {
        buddy.setName("Abdillahi");
        assertEquals("Name should be Abdillahi", "Abdillahi", buddy.getName());
    }

    @Test
    public void setAddressGetAddress() {
        buddy.setAddress("123 Carleton Way");
        assertEquals("Address should be 123 Carleton Way", "123 Carleton Way", buddy.getAddress());
    }

    @Test
    public void setPhoneNumberGetPhoneNumber() {
        buddy.setPhoneNumber("613-999-9999");
        assertEquals("Phone number should be 613-999-9999", "613-999-9999", buddy.getPhoneNumber());
    }

}