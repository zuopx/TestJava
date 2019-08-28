/**
 * 
 */

package percy.java.concurrent.basic.collaboration.meanwhile;

/**
 * FireFlag
 */
public class FireFlag {

  private volatile boolean fired = false;

  public synchronized void waitForFire() throws InterruptedException {
    while (!fired) {
      wait();
    }
  }

  public synchronized void fire() {
    fired = true;
    notifyAll();
  }
}