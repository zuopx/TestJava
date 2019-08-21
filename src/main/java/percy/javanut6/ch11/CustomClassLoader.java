/**
 * Custom class loader.
 */

package percy.javanut6.ch11;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * CustomClassLoador
 */
public class CustomClassLoader {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String current = new File(".").getCanonicalPath();
    System.out.println(current);
    try (URLClassLoader uc = new URLClassLoader(
      new URL[] { new URL("file://" + current + "/") })) {
      Class<?> cls = uc.loadClass("javanut6.ch05.Shape");
      System.out.println(cls.getName());
    } catch (Exception e) {
      e.printStackTrace();
    }

    Class<?> cls2 = Class.forName("javanut6.ch05.Singleton");
    System.out.println(cls2.getName());
    System.out.println("Done!");
  }
}