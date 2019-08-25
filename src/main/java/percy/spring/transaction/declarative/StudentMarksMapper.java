/**
 * 
 */

package percy.spring.transaction.declarative;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * StudentMarksMapper
 */
public class StudentMarksMapper implements RowMapper<StudentMarks> {

  @Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
    StudentMarks sm = new StudentMarks();
    sm.setAge(rs.getInt("age"));
    sm.setId(rs.getInt("id"));
    sm.setMark(rs.getInt("mark"));
    sm.setName(rs.getString("name"));
    sm.setSid(rs.getInt("sid"));
    sm.setYear(rs.getInt("year"));
		return sm;
	}

  
}