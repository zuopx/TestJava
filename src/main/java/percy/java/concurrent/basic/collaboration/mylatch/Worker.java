/**
 * 
 */

package percy.java.concurrent.basic.collaboration.mylatch;

/**
 * Worker
 */
public class Worker extends Thread {

  private MyLatch latch;

  public Worker(MyLatch latch) {
    this.latch = latch;
  }

  @Override
  public void run() {
    try {
      Thread.sleep((int) (Math.random() * 1000));
      latch.countDonw();
      System.out.println("end job " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}