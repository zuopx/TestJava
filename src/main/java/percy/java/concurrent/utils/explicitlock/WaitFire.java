/**
 * 
 */

package percy.java.concurrent.utils.explicitlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * WaitFire
 */
public class WaitFire extends Thread {

  private volatile boolean fired = false;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  @Override
  public void run() {
    lock.lock();
    try {
      while (fired) {
        condition.await();
      }
      System.out.println("fired");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void fire() {
    lock.lock();
    try {
      fired = true;
      condition.signal();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    WaitFire thread = new WaitFire();
    thread.start();
    Thread.sleep(1000);
    thread.fire();
    System.out.println("Done!");
  }
}