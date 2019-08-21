/**
 * JDBC Statement has some major issues and should be avoided in all casees.
 * https://www.journaldev.com/2489/jdbc-statement-vs-preparedstatement-sql-injection-example
 */

 package percy.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
  * PreparedStatementDemo
  */
 public class PreparedStatementDemo {
 
    public static void main(String[] args) throws SQLException{
        @SuppressWarnings("resource")
         Scanner scanner = new Scanner(System.in);

         System.out.println("Please input email: ");
         String email = scanner.nextLine();
         System.out.println("Email id: " + email);

         System.out.println("Please input password: ");
         String password = scanner.nextLine();
         System.out.println("Password: " + password);
         
         printUserData(email, password);
     }

    private static void printUserData(String email, String password) throws SQLException{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select id, name, email, country, password from Users " +
                        "where email = ? and password = ?";
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(query);

            //set the parameters
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + ", " +
                                resultSet.getString("country"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            preparedStatement.close();
            conn.close();
        }
    }
  }