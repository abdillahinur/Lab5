package Application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private Long id;
    private List<BuddyInfo> buddies;
    private String name;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public void setBuddies(ArrayList<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuddyInfo getBuddy(int x) {
        return buddies.get(x);
    }

    public void addBuddy(BuddyInfo buddy) {
        if(buddy == null) {
            System.out.println("The Application.BuddyInfo you are trying to add cannot be null");
        }
        else {
            buddies.add(buddy);
        }
    }

    public void removeBuddy(int buddyIndex) {
        if (buddyIndex < buddies.size() && buddyIndex >= 0) {
            buddies.remove(buddyIndex);
        }
    }

    public void clear() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public String toString() {
        String s = "";

        for (BuddyInfo b:buddies) {
            s += b.getName() + " " + b.getPhoneNumber() + " " + b.getAddress();
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        BuddyInfo abdi = new BuddyInfo("Abdillahi", "123 Application.Main Street", "613-555-6666");
        BuddyInfo Joe = new BuddyInfo("Joe", "12 Side Road", "819-123-6789");

        addressBook.addBuddy(abdi);
        addressBook.addBuddy(Joe);

        System.out.println(addressBook);
    }

}
