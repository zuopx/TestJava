/**
 * 
 */

package percy.mybatis.zetcode.javaconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * MyBatisJavaConfClient
 */
public class MyBatisJavaConfClient {

  private static SqlSessionFactory sqlSessionFactory = null;

  public static void main(String[] args) {
    Properties prop = new Properties();
    prop.setProperty("driver", "com.mysql.jdbc.Driver");
    prop.setProperty("url", "jdbc:mysql://localhost:3306/test");
    prop.setProperty("user", "test");
    prop.setProperty("password", "test1234");

    MyDatasourceFactory myDatasourceFactory = new MyDatasourceFactory();
    myDatasourceFactory.setProperties(prop);
    DataSource dataSource = myDatasourceFactory.getDataSource();

    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = 
      new Environment("development", transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(MyMapper.class);

    sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int numberOfBooks = sqlSession.selectOne("getNumberOfBooks");
      System.out.printf("There are %d books.\n", numberOfBooks);
    }

    System.out.println("Done!");
  }
}