package Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "AddressBook", path = "books")
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findAll();
    List<AddressBook> findByName(String name);
    AddressBook findById(long id);
}