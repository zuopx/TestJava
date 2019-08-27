/**
 * 
 */

package percy.mybatis.zetcode.book;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * BookMapper
 */
public interface BookMapper {

  @Select("select * from MyBooks where id=#{id}")
  public Book getBookById(Long id);

  @Select("select * from MyBooks where author=#{author}")
  public List<Book> getBookByAuthor(String author);

  @Insert("insert into MyBooks(author, title, published, remark) "
    + "values(#{author}, #{title}, #{published}, #{remark})")
  public void insertBook(String author, String title, int published, String remark);
  
}