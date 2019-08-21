/**
 * First demo, create thread and run it, with lambda expression
 */

package percy.java.concurrent;

/**
 * Demo1WithLambda
 */
public class Demo1WithLambda {

  public static void main(String[] args) {
    Thread t = new Thread(() -> {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Hello, Java.");
    });
    t.start();
    System.out.println("Hello, Main thread.");
  }
}