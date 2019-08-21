/**
 * https://www.journaldev.com/2494/jdbc-batch-insert-update-mysql-oracle
 */

 package percy.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

/**
  * BatchMode
  */
 public class BatchMode {
 
     public static void main(String[] args) {
         Connection conn = null;
         PreparedStatement ps = null;
         String query = "insert into Employee values (?, ?)";
         try {
             conn = DBConnection.getConnection();
             conn.setAutoCommit(false);
             ps = conn.prepareStatement(query);

             long start = System.currentTimeMillis();
             for (int i=0; i!=10000; i++) {
                 ps.setInt(1, i);
                 ps.setString(2, "name" + i);
                 ps.addBatch();
                 if ((i+1) % 1000 == 0) {
                     System.out.println(i+1);
                     int[] results = ps.executeBatch();
                     System.out.println(Arrays.toString(results));
                     conn.commit();
                 }
             }
             System.out.println("Time taken: " + (System.currentTimeMillis()-start));
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 conn.close();
                 ps.close();
             } catch (Exception e) {
                e.printStackTrace();
            }
         }
     }
 }