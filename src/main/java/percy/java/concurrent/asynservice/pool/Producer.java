/**
 * A simple Producer class.
 */

package percy.java.concurrent.asynservice.pool;

import java.util.concurrent.ExecutorService;

/**
 * Producer
 */
public class Producer extends Thread {

  private ExecutorService executorService;

  public Producer(ExecutorService executorService) {
    System.out.println("create producer");
    this.executorService = executorService;
  }

  @Override
  public void run() {
    int i = 0;
    for (;;) {
      try {
        Thread.sleep((int) (Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      String name = Thread.currentThread().getName() + ": task-" + Integer.toString(i);
      System.out.println("producer submits task: " + name);
      executorService.submit(new Task(name));
      i++;
    }
  }

}