/**
 * Utility class to fetch SqlSessionFactory using SqlSessionFactoryBuilder.
 */

package percy.mybatis.zetcode.book;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisUtil
 */
public class MyBatisUtils {

  private static SqlSessionFactory sqlSessionFactory;

  static {
    String resource = "percy/mybatis/zetcode/book/mybatis-config.xml";
    InputStream inputStream;
    try {
      inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static SqlSessionFactory getSqlSessionFactory() {
    return sqlSessionFactory;
  }
}