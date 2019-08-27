/**
 * 
 */

package percy.mybatis.zetcode.javaconfig;

import org.apache.ibatis.annotations.Select;

/**
 * MyMapper
 */
public interface MyMapper {

  @Select("select count(*) from MyBooks")
  public int getNumberOfBooks();
}