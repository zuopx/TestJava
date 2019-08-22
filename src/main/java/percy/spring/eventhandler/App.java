package percy.spring.eventhandler;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/eventhandler/Beans.xml");
        context.start();
        HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
        System.out.println(obj.getMessage());
        context.stop();
        System.out.println("Done!");
    }
}