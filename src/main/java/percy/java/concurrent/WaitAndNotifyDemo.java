/**
 * A small example showing the cooperation relationship between threads by using
 * wait() and notify()
 */

package percy.java.concurrent;

/**
 * WaitAndNotifyDemo
 */
public class WaitAndNotifyDemo extends Thread {

  private volatile boolean fire = false;

  @Override
  public void run() {
    try {
      synchronized (this) {
        while (!fire) {
          wait();
        }
        System.out.println("fired");
      }
    } catch (Exception InterrupException) {
    }
  }

  public synchronized void fire() {
    this.fire = true;
    notify();
  }

  public static void main(String[] args) throws InterruptedException{
    WaitAndNotifyDemo wn = new WaitAndNotifyDemo();
    wn.start();
    Thread.sleep(5000);
    System.out.println("fire");
    wn.fire();
  }
}
