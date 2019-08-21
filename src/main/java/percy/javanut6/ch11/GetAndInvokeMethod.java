/**
 * Get and invoke method.
 */

package percy.javanut6.ch11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * GetAndInvokeMethod
 */
public class GetAndInvokeMethod {

  static class X {
    
    public void work(int i, String s) {
      System.out.printf("Called: i=%d, s=%s\n", i, s);
    }

    public void work(int i) {
      System.out.println("Unexpected call!");
    }
  }

  public static void main(String[] args) throws NoSuchMethodException, 
                                            SecurityException, 
                                            IllegalAccessException, 
                                            IllegalArgumentException, 
                                            InvocationTargetException {
    Class<?> clsX = X.class;

    Class<?>[] argTypes = {int.class, String.class};

    Method worker = clsX.getMethod("work", argTypes);

    Object[] myArgs = {42, "Hello, Java!"};

    worker.invoke(new X(), myArgs);
  }
}