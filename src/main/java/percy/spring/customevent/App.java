package percy.spring.customevent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/customevent/Beans.xml");
        CustomEventPublisher publisher = (CustomEventPublisher) context.getBean("customEventPublisher");
        publisher.publish();
        publisher.publish();

        System.out.println("Done!");
    }
}