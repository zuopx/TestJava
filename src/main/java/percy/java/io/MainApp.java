/**
 * System.out, System.in
 * Scanner: https://docs.oracle.com/javase/8/docs/api/index.html
 */

package percy.java.io;

import java.util.Scanner;

/**
 * MainApp
 */
public class MainApp {


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    System.out.println(s);

    System.out.println("Done!");
  }
}