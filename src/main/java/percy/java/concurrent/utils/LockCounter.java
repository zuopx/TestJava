/**
 * AtomicInteger demo.
 */

package percy.java.concurrent.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CASCouter
 */
public class LockCounter {

  private static Counter counter = new Counter();

  static class Counter {
    private final Lock lock = new ReentrantLock();
    private volatile int value = 0;

    public void incr() {
      lock.lock();
      try {
        value++;
      } finally {
        lock.unlock();
      }
    }

    public int getValue() {
      return value;
    }
  }

  static class Visitor extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
        counter.incr();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    int num = 1000;
    Thread[] visitors = new Thread[num];
    for (int i = 0; i < num; i++) {
      visitors[i] = new Visitor();
      visitors[i].start();
    }
    for (int i = 0; i < num; i++) {
      visitors[i].join();
    }
    System.out.println(counter.getValue());
    
    System.out.println("Done!");
  }
}
