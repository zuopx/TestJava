package percy.java.common;

import java.util.Scanner;
/**
 * StringToBinaryInt
 */
public class StringToBinaryInt {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();
    String s3 = add(s1, s2);
    System.out.println(s3);

    System.out.println("Done!");
  }

  private static String add(String s1, String s2) {
    Integer integer1 = Integer.valueOf(s1, 2);
    Integer integer2 = Integer.valueOf(s2, 2);
    Integer integer3 = integer1 + integer2;
    String s3 = Integer.toString(integer3, 2);
    return s3;
  }
}