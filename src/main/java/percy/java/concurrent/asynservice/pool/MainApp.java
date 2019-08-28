/**
 * 
 */

package percy.java.concurrent.asynservice.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    int num = 4;
    ExecutorService executorService = 
      new ThreadPoolExecutor(num, num, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), new Consumer());
    for (int i = 0; i < num; i++) {
      new Producer(executorService).start();
    }
    
    System.out.println("Done!");
  }
}