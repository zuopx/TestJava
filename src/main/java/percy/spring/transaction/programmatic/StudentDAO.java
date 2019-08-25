/**
 * Student and Marks DAO.
 */

package percy.spring.transaction.programmatic;

import java.util.List;

import javax.sql.DataSource;

/**
 * StudentDAO
 */
public interface StudentDAO {

  public void setDataSource(DataSource ds);

  public void create(String name, Integer age, Integer mark, Integer year);

  public List<StudentMarks> listStudents();
}