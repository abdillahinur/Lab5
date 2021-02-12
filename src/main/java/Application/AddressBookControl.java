package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AddressBookControl {

    @Autowired
    private AddressBookRepo book;

    @Autowired
    private BuddyInfoRepo buddy;

    @GetMapping("/")
    public String getBook(Model model) {
        AddressBook b = book.findAll().get(0);
        model.addAttribute("buddies", b.getBuddies());
        return "book";
    }

}
