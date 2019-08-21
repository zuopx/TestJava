/**DBConnection
 * 
 */

package percy.java.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBConnection {

    public static Connection getConnection() {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        Connection conn = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/db.properties");
            properties.load(fileInputStream);

            // load the driver class
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            conn = DriverManager.getConnection(properties.getProperty("DB_URL"),
                                        properties.getProperty("DB_USERNAME"),
                                        properties.getProperty("DB_PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}