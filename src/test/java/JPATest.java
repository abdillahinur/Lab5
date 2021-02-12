import Application.AddressBook;
import Application.BuddyInfo;
import org.junit.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static org.junit.Assert.assertTrue;


public class JPATest {

    @Test
    public void performJPA() {
        AddressBook book = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo();
        BuddyInfo buddy2 = new BuddyInfo();

        buddy1.setName("Abdillahi");
        buddy2.setName("Joe");

        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(book);
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM Application.AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("\nList of Address Books");
        for (AddressBook a : results) {
            System.out.println("Address Book id = " + a.getId());
            System.out.println("\nList of BuddyInfos");
            for (BuddyInfo b : a.getBuddies()) {
                assertTrue(b.getName() == "Abdillahi" || b.getName() == "Joe");
                System.out.println(b.getName() + " id = " + b.getId());
            }
        }
        System.out.println("");
        em.close();
        emf.close();
    }
}
