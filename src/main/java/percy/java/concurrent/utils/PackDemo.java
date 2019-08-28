/**
 * LockSupport pack().
 */

package percy.java.concurrent.utils;

import java.util.concurrent.locks.LockSupport;

/**
 * PackDemo
 */
public class PackDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      LockSupport.park();
      System.out.println("exit");
    });

    thread.start();
    Thread.sleep(1000);
    LockSupport.unpark(thread);

    System.out.println("Done!");
  }
}