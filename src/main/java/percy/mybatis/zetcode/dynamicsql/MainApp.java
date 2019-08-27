/**
 * 
 */

package percy.mybatis.zetcode.dynamicsql;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MainApp
 */
public class MainApp {

  private static SqlSessionFactory sqlSessionFactory = null;

  public static void main(String[] args) throws IOException {
    String resource = "percy/mybatis/zetcode/dynamicsql/mybatis-config.xml";
    Reader reader = null;
    SqlSession sqlSession = null;

    reader = Resources.getResourceAsReader(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    try {
      sqlSession = sqlSessionFactory.openSession();
      Book book = sqlSession.selectOne("getBook", 1);
      System.out.println(book);

      List<Book> books = sqlSession.selectList("getBook");
      for (Book var : books) {
        System.out.println(var);
      }
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }

    System.out.println("Done!");
  }
}