/**
 * A simple Consumer class.
 */

package percy.java.concurrent.asynservice.pool;

import java.util.concurrent.ThreadFactory;

/**
 * Consumer
 */
public class Consumer implements ThreadFactory {

  @Override
  public Thread newThread(Runnable r) {
    System.out.println("create consumer");
    Thread thread = new Thread(r);
    return thread;
  }

}