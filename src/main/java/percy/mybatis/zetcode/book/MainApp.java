/**
 * 
 */

package percy.mybatis.zetcode.book;

import java.io.IOException;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * MainApp
 */
public class MainApp {

  private static SqlSessionFactory sqlSessionFactory = null;

  public static void main(String[] args) throws IOException {
    SqlSession sqlSession = null;

    sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
    sqlSessionFactory.getConfiguration().addMapper(BookMapper.class);

    try {
      sqlSession = sqlSessionFactory.openSession();

      List<Book> books = sqlSession.selectList("getBookByAuthor", "Leo Tolstoy");
      for (Book var : books) {
        System.out.println(var);
      }

      // Book newbook = new Book();
      // newbook.setAuthor("Leo Tolstoy");
      // newbook.setPublished(1605);
      // newbook.setRemark("First modern novel");
      // newbook.setTitle("Miguel de Cervantes");
      // sqlSession.update("insertBook", newbook);

      // sqlSession.commit();
    } finally {
      if (sqlSession != null) {
        sqlSession.close();
      }
    }

    System.out.println("Done!");
  }
}