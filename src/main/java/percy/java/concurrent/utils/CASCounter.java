/**
 * AtomicInteger demo.
 */

package percy.java.concurrent.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CASCouter
 */
public class CASCounter {

  private static AtomicInteger counter = new AtomicInteger();

  static class Visitor extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
        counter.incrementAndGet();
      }
    }
  }

  public static void main(String[] args) {
    int num = 1000;
    Thread[] visitors = new Thread[num];
    for (int i = 0; i < num; i++) {
      visitors[i] = new Visitor();
      visitors[i].start();
    }

    System.out.println(counter.get());
    
    System.out.println("Done!");
  }
}
