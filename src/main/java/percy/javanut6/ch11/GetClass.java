/**
 * several methods to get class objects and their metadata
 */

package percy.javanut6.ch11;

/**
 * GetClass
 */
public class GetClass {

  public static void main(String[] args) {
    Class<?> myCl = GetClass.class;
    // System.out.println(String.class);
    System.out.println(myCl);
    System.out.println("Hello, Java!");
  }
}