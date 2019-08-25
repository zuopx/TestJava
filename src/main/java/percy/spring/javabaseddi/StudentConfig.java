/**
 * Configuration file for class Student.
 */

package percy.spring.javabaseddi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StudentConfig
 */
@Configuration
public class StudentConfig {

  @Bean
  public Student student1(){
    return new Student();
  }

  @Bean
  public Student student2() {
    Student student = student1();
    student.setAge(23);
    student.setName("percy");
    return student;
  }
}