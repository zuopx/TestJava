/**
 * Two configuration way to get MySQL version.
 */

package percy.mybatis.zetcode.version;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MySQLVersion
 */
public class MySQLVersion_xmlmapper {

  private static SqlSessionFactory factory = null;

  public static void main(String[] args) throws IOException {
    String resource = "percy/mybatis/zetcode/version/mybatis-config2.xml";
    Reader reader = null;
    SqlSession session = null;

    reader = Resources.getResourceAsReader(resource);
    factory = new SqlSessionFactoryBuilder().build(reader);
    reader.close();

    try {
      session = factory.openSession();
      String version = session.selectOne("getMySQLVersion");
      System.out.println(version);
    } finally {
      if (session != null) {
        session.close();
      }
    }

    System.out.println("Done!");
  }
}