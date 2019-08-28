/**
 * 
 */

package percy.java.concurrent.basic.collaboration.mylatch;

/**
 * Racer
 */
public class Racer extends Thread {

  private MyLatch latch;

  public Racer(MyLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep((int) (Math.random() * 100));
      latch.await();
      System.out.println("start run " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}