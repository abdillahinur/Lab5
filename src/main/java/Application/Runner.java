package Application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public void launch() {
        String[] contextPaths = new String[] {"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public static void main(String[] args) {

       Runner r = new Runner();
       r.launch();

       //Application.AddressBookControl a = new Application.AddressBookControl();
       //a.setListeners();
       //a.displayView();
    }
}
