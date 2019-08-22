package percy.spring.postprocess;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/postprocess/Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		String message = obj.getMessage();
		System.out.println(message);
		context.registerShutdownHook();

		System.out.println("Done!");
	}
}