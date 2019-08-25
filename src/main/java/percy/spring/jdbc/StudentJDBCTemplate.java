/**
 * An implementation of StudentDAO.
 */

package percy.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * StudentJDBCTemplate
 */
public class StudentJDBCTemplate implements StudentDAO {

  private JdbcTemplate jt;

  @Override
  public void setDataSource(DataSource ds) {
    jt = new JdbcTemplate(ds);
  }

  @Override
  public void create(String name, Integer age) {
    String sql = "insert into Student (name, age) value (?, ?)";
    jt.update(sql, name, age);
    System.out.println("Done, create!");
  }

  @Override
  public Student getStudent(Integer id) {
    String sql = "select * from Student where id = ?";
    Student student = jt.queryForObject(sql, new Object[] { id }, new StudentMapper());
    System.out.println("Done, getStudent!");
    return student;
  }

  @Override
  public List<Student> listStudent() {
    String sql = "select * from Student";
    List<Student> students = jt.query(sql, new StudentMapper());
    System.out.println("Done, listStudent!");
    return students;
  }

  @Override
  public void delete(Integer id) {
    String sql = "delete from Student where id = ?";
    jt.update(sql, id);
    System.out.println("Done, delete!");
  }

  @Override
  public void update(Integer id, Integer age) {
    String sql = "update Student set age = ? where id = ?";
    jt.update(sql, age, id);
    System.out.println("Done, update!");
  }

  @Override
  public String toString() {
    return "StudentJDBCTemplate [jt=" + jt + "]";
  }
}