/**
 * 
 */

package percy.java.concurrent.basic.collaboration.meanwhile;

/**
 * Racer
 */
public class Racer extends Thread {

  private FireFlag fireFlag;

  public Racer(FireFlag fireFlag) {
    this.fireFlag = fireFlag;
  }

  @Override
  public void run() {
    try {
      fireFlag.waitForFire();
      System.out.println("start run " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}