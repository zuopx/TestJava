/**
 * https://www.journaldev.com/2509/java-datasource-jdbc-datasource-example
 */

package percy.java.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * DBCPDataSourceFactory
 */
public class DBCPDataSourceFactory {

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/db.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        ds.setDriverClassName(props.getProperty("DB_DRIVER_CLASS"));
        ds.setUrl(props.getProperty("DB_URL"));
        ds.setUsername(props.getProperty("DB_USERNAME"));
        ds.setPassword(props.getProperty("DB_PASSWORD"));

        return ds;
    }
}