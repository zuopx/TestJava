/**
 * 
 */

package percy.java.concurrent.asynservice.pool;


/**
 * Task
 */
public class Task implements Runnable {

  private String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    try {
      Thread.sleep((int) (Math.random() * 1000));
      System.out.println("consumer processes task: " + name);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}