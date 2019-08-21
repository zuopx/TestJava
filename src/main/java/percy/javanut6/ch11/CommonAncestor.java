/**
 * Get commom ancestor of classes.
 */

package percy.javanut6.ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * CommonAncestor
 */
public class CommonAncestor {

  public static Class<?> commonAncestor(Class<?> cls1, Class<?> cls2) {
    if (cls1 == null || cls2 == null || cls1.isPrimitive() || cls2.isPrimitive()) {
      return null;
    }
    List<Class<?>> ancestors = new ArrayList<>();
    Class<?> c = cls1;
    while (!c.equals(Object.class)) {
      ancestors.add(c);
      c = c.getSuperclass();
    }
    c = cls2;
    while (!c.equals(Object.class)) {
      for (Class<?> var : ancestors) {
        if (c.equals(var)) {
          return c;
        }
      }
      c = c.getSuperclass();
    }
    return Object.class;
  }

  public static void main(String[] args) {
    System.out.println(commonAncestor(int.class, String.class));
    System.out.println(commonAncestor(Integer.class, Double.class));
    System.out.println(commonAncestor(ArrayList.class, HashSet.class));
    System.out.println("Done!");
  }
}