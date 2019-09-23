/**
 * Generics wildcard ?
 */

package percy.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * WildCard
 */
public class WildCard {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    helper1();
    //! use wildcard ?
    List<?> list2 = list;
    System.out.println(list2);

    list.add("b");
    list.add("c");
    //! list.add(1), compile error
    System.out.println(list2);

    //! can't write
    // list2.add("d");

    System.out.println("Done!");
  }

  private static void helper1() {
    List<?> list = new ArrayList<Integer>();
    String[] strings = {"a"};
    Object[] objects = strings;
    objects[0] = 1;
  }
}