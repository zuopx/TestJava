/**
 * Main app.
 */

package percy.spring.annotationbaseddi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/annotationbaseddi/Beans.xml");
    TextEditor textEditor = (TextEditor) context.getBean("textEditor");
    System.out.println(textEditor);
    textEditor.spellCheck();

    System.out.println("Done!");
  }
}