package Application;

import java.awt.*;
import javax.swing.*;


public class AddressBookView extends JFrame {
    private JMenuBar BookMenuBar;
    private JList BookList;
    private JMenu AddressBookMenu, BuddyInfoMenu;
    private JMenuItem Save, Create, Add;

    public AddressBookView() {
        super();
        //Build the MenuBar and Menus
        BookMenuBar = new JMenuBar();
        AddressBookMenu = new JMenu("Application.AddressBook");
        BuddyInfoMenu = new JMenu("Application.BuddyInfo");
        Create = new JMenuItem("Create");
        Save = new JMenuItem("Save");
        Add = new JMenuItem("Add");
        AddressBookMenu.add(Create);
        AddressBookMenu.add(Save);
        BuddyInfoMenu.add(Add);
        BookMenuBar.add(AddressBookMenu);
        BookMenuBar.add(BuddyInfoMenu);
        BookList = new JList();
        BookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void init() {
        Container panel = getContentPane();
        panel.setLayout(new BorderLayout());
        panel.add(BookMenuBar, BorderLayout.NORTH);
        panel.add(BookList, BorderLayout.CENTER);
        setVisible(true);
        Create.setEnabled(true);
        Save.setEnabled(false);
        Add.setEnabled(false);
        AddressBookMenu.add(Create);
        AddressBookMenu.add(Save);
        BuddyInfoMenu.add(Add);
        BookMenuBar.add(AddressBookMenu);
        BookMenuBar.add(BuddyInfoMenu);
        BookList = new JList();
        setSize(500, 500);

    }

    private JMenuItem buildMenuItem(String name, boolean enabled) {
        JMenuItem item = new JMenuItem(name);
        item.setEnabled(enabled);
        return item;
    }

    public String buildPrompt(String Prompt) {
        return JOptionPane.showInputDialog(Prompt);
    }

    public JList getDisplay() {
        return BookList;
    }

    public JMenuItem getCreate() {
        return Create;
    }

    public JMenuItem getAdd() {
        return Add;
    }
    public JMenuItem getSave() {
        return Save;
    }

}
