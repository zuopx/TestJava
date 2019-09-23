/**
 * Lambda APIs are used for functional style programming.
 * Important functional idioms: filter, map, reduce.
 */

package percy.java.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * LambdaTest
 */
public class LambdaTest {

  private static String[] strings = {"tiger", "cat", "TIGER", "Tiger", "leopard"};
  private static List<String> list = Arrays.asList(strings);

  public static void main(String[] args) {
    // filterTest();
    // mapTest();
    // foreachTest();
    reduceTest();

    System.out.println("Done!");
  }

  private static void reduceTest() {
    String sumLength = list.stream().reduce("", (x, y) -> {return x + y;});
    System.out.println(sumLength);
  }

  /**
   * function in place
   */
  private static void foreachTest() {
    // Two ways are same.
    list.stream().forEach(System.out::println);
    list.forEach(System.out::println);
  }

  /**
   * 
   */
  private static void mapTest() {
    List<Integer> nameLength = list.stream().map(String::length).collect(Collectors.toList());
    System.out.println(nameLength);
  }

  /**
   * predicate
   */
  private static void filterTest() {
    String search = "tiger";
    String tigers = list.stream()
                        .filter(s -> s.equalsIgnoreCase(search))
                        .collect(Collectors.joining(","));
    System.out.println(tigers);

    Predicate<String> p = s -> s.equalsIgnoreCase(search);
    Predicate<String> combined = p.or(s -> s.equals("leopard"));
    String pride = list.stream()
                        .filter(combined)
                        .collect(Collectors.joining(","));
    System.out.println(pride);
  }
}