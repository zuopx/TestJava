package percy.java.collection;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSetTest
 */
public class SortedSetTest {

  public static void main(String[] args) {
    String[] strings = new String[] {"d", "a", "b", "c", "1"};
    SortedSet<String> sortedSet = new TreeSet<>(Arrays.asList(strings));
    for (String var : sortedSet) {
      System.out.println(var);
    }

    String first = sortedSet.first();
    String last = sortedSet.last();

    SortedSet<String> tail = sortedSet.tailSet(first + '\0');
    System.out.println(tail);

    SortedSet<String> head = sortedSet.headSet(last);
    System.out.println(head);

    SortedSet<String> middle = sortedSet.subSet(first + '\0', last);
    System.out.println(middle);

    System.out.println("Done!");
  }  
}