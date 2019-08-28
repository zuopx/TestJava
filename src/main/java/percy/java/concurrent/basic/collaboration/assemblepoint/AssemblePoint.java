/**
 * 
 */

package percy.java.concurrent.basic.collaboration.assemblepoint;

/**
 * AssemblePoint
 */
public class AssemblePoint {

  private int count;

  public AssemblePoint(int count) {
    this.count = count;
  }

  public synchronized void await() throws InterruptedException {
    if (count > 0) {
      count--;
      if (count == 0) {
        notifyAll();
      } else {
        while (count != 0) {
          wait();
        }
      }
    }
  }
}