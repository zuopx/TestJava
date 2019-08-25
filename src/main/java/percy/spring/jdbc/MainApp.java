/**
 * Main app.
 */

package percy.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/jdbc/Beans.xml");
    StudentJDBCTemplate sjt = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
    System.out.println(sjt);
    // sjt.create("Nuha", 2);
    // sjt.create("Zara", 11);
    // sjt.create("Ayan", 15);
    List<Student> students = sjt.listStudent();
    for (Student var : students) {
      System.out.println(var);
    }
    sjt.update(11, 20);
    System.out.println(sjt.getStudent(11));

    System.out.println("Done!");
  }
}