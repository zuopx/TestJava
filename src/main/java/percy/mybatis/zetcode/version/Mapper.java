/**
 * Map the java method to the SQL statement, using annotation.
 */

package percy.mybatis.zetcode.version;

import org.apache.ibatis.annotations.Select;

/**
 * MyMapper
 */
public interface Mapper {

  @Select("select version()")
  public String getMySQLVersion();
}