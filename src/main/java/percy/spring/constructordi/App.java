package percy.spring.constructordi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/constructordi/Beans.xml");
        TextEditor textEditor = (TextEditor)context.getBean("textEditor");
        textEditor.spellcheck();
   
        System.out.println("Done!");
    }
}