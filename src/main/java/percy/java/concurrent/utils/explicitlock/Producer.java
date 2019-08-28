/**
 * A simple Producer class.
 */

package percy.java.concurrent.utils.explicitlock;

/**
 * Producer
 */
public class Producer extends Thread {

  private MyBlockingQueue<String> queue;

  @Override
  public void run() {
    int num = 0;
    try {
      while (true) {
        String task = String.valueOf(num);
        queue.put(task);
        num++;
        System.out.println("produce task " + task);
        Thread.sleep((int)(Math.random() * 1000));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Producer(MyBlockingQueue<String> queue) {
    this.queue = queue;
  }
}