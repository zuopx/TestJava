package percy.spring.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {

        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/inheritance/Beans.xml");
        HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
        HelloIndia obj2 = (HelloIndia) context.getBean("helloIndia");

        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("Done!");
    }
}