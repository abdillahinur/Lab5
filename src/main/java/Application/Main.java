package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepo repository) {
        return (args) -> {
            AddressBook a1 = new AddressBook();
            a1.setName("Abdillahi");
            AddressBook a2 = new AddressBook();
            a2.setName("Book2");

            BuddyInfo b1 = new BuddyInfo("Abdillahi", "123 Main Street", "613-990-8888");
            BuddyInfo b2 = new BuddyInfo("Shoaib", "88 Centre Road", "819-123-4567");
            BuddyInfo b3 = new BuddyInfo("Tamer", "55 74rd Street", "613-990-8888");
            BuddyInfo b4 = new BuddyInfo("Meet", "123 main street", "819-666-7777");

            a1.addBuddy(b1);
            a1.addBuddy(b2);
            a2.addBuddy(b3);
            a2.addBuddy(b4);

            repository.save(a1);
            repository.save(a2);


            // fetch all AddressBooks/BuddyInfos
            log.info("Fetching all AddressBooks and their corresponding BuddyInfos");
            log.info("-------------------------------");
            for (AddressBook a : repository.findAll()) {
                log.info("Address Book ID = " + a.getId());
                for (BuddyInfo b : a.getBuddies()) {
                    log.info(b.getName() + " ( id = " + b.getId() + ")" );
                }
            }
            log.info("");

            // fetch an individual customer by ID
            AddressBook a = repository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(a.toString());
            log.info("");

            // fetch AddressBook by name
            log.info("AddressBook found with findByName('Abdillahi'):");
            log.info("--------------------------------------------");
            repository.findByName("Abdillahi").forEach(Abdillahi -> {
                log.info(Abdillahi.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
