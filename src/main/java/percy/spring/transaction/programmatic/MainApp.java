/**
 * Programmatic transaction management.
 */

package percy.spring.transaction.programmatic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext context = new ClassPathXmlApplicationContext("percy/spring/transaction/programmatic/Beans.xml");
    StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
    // studentJDBCTemplate.create("Zara", 11, 99, 2010);
    // studentJDBCTemplate.create("Nuha", 20, 97, 2010);
    // studentJDBCTemplate.create("Ayan", 25, 100, 2011);
    List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
    for (StudentMarks var : studentMarks) {
      System.out.println(var);
    }

    System.out.println("Done!");
  }
}