package percy.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/hello/Beans.xml");
		HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
		obj.getMessage();
	}
}
