/**
 * An Implementation of StudentDAO.
 */

package percy.spring.transaction.declarative;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
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
  public void create(String name, Integer age, Integer mark, Integer year) {
    try {
      String sql1 = "insert into Student (name, age) values (?, ?)";
      jt.update(sql1, name, age);
      System.out.println("Done, sql1.");

      String sql2 = "select max(id) from Student";
      Integer sid = jt.queryForObject(sql2, Integer.class);
      System.out.println("Done, sql2.");

      String sql3 = "insert Marks (sid, mark, year) values (?, ?, ?)";
      jt.update(sql3, sid, mark, year);
      System.out.println("Done, sql3.");

      throw new RuntimeException("Simulate expection condition.");
    } catch (DataAccessException e) {
      System.out.println("Error in creating record.");
      throw e;
    }
  }

  @Override
  public List<StudentMarks> listStudents() {
    String sql = "select * from Student, Marks where Student.id=Marks.sid";
    List<StudentMarks> studentMarks = jt.query(sql, new StudentMarksMapper());
    return studentMarks;
  }

  @Override
  public String toString() {
    return "StudentJDBCTemplate [jt=" + jt + "]";
  }
}