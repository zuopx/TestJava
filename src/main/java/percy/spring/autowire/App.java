package percy.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/autowire/BeansByType.xml");
        TextEditor obj = (TextEditor)context.getBean("textEditor");
        obj.spellCheck();

        System.out.println("Done!");
    }
}