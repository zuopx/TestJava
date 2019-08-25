/**
 * Student with age and name.
 */

package percy.spring.annotationbaseddi;

import org.springframework.beans.factory.annotation.Required;

/**
 * Student
 */
public class Student {

  private Integer age;
  private String name;

  public Integer getAge() {
    return age;
  }

  @Required
  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  @Required
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student [age=" + age + ", name=" + name + "]";
  }
}