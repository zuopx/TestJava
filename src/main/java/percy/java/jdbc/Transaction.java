/**
 * https://www.journaldev.com/2494/jdbc-batch-insert-update-mysql-oracle
 */

package percy.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * BatchMode
 */
public class Transaction {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into Employee values (?, ?)";
        try {
            conn = DBConnection.getConnection();
            // start transaction server
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);

            String name1 = "Pankaj";
            String name2 = "Pankaj Kumar"; // longer than column length
            String name3 = "Kumar";

            ps.setInt(1, 1);
            ps.setString(2, name1);
            ps.addBatch();

            ps.setInt(1, 2);
            ps.setString(2, name2);
            ps.addBatch();

            ps.setInt(1, 3);
            ps.setString(2, name3);
            ps.addBatch();

            int[] results = ps.executeBatch();
            conn.commit();

            System.out.println(results.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}