package percy.spring.collectiondi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/collectiondi/Beans.xml");
        JavaCollection javaCollection = (JavaCollection)context.getBean("javaCollection");
        System.out.println(javaCollection.getAddressList());
        System.out.println(javaCollection.getAddressSet());
        System.out.println(javaCollection.getAddressMap());
        System.out.println(javaCollection.getAddressProp());
        
        System.out.println("Done!");
    }
}