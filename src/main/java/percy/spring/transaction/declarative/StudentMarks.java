package percy.spring.transaction.declarative;

/**
 * StudentMarks
 */
public class StudentMarks {

  private Integer id;
  private String name;
  private Integer age;
  private Integer sid;
  private Integer mark;
  private Integer year;

  public String getName() {
    return name;
  }

  public Integer getSid() {
    return sid;
  }

  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getMark() {
    return mark;
  }

  public void setMark(Integer mark) {
    this.mark = mark;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "StudentMarks [age=" + age + ", id=" + id + ", mark=" + mark + ", name=" + name + ", sid=" + sid + ", year="
        + year + "]";
  }
}