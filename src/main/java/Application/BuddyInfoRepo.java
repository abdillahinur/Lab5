package Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path = "buddies")
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long> {

    List<AddressBook> findByName(String name);
    AddressBook findById(long id);

}

