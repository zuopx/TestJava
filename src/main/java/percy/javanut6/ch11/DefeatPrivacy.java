/**
 * Access to private field.
 */

package percy.javanut6.ch11;

import java.lang.reflect.Field;

/**
 * DefeatPrivacy
 */
public class DefeatPrivacy {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    new DefeatPrivacy().process();
  }

  private void process() throws IllegalArgumentException, IllegalAccessException {
    X x = new X();
    Field[] fields =  X.class.getDeclaredFields();
    for (Field var : fields) {
      var.setAccessible(true);
      System.out.println(var + " = " + var.get(x));
      var.setAccessible(false);
    }
  }
}


class X {

  @SuppressWarnings("unused")
  private int p = 42;
  int q = 3;
}
