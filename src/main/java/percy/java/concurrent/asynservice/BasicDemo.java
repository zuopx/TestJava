/**
 * 
 */

package percy.java.concurrent.asynservice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * BasicDemo
 */
public class BasicDemo {

  static class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      int sleepSeconds = new Random().nextInt(10);
      Thread.sleep(sleepSeconds * 1000);
      return sleepSeconds;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    // ExecutorService executorService = new SimpleExecutorService();
    Future<Integer> future = executorService.submit(new Task());
    Thread.sleep(100);
    try {
      System.out.println(future.get());
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    executorService.shutdown();

    System.out.println("Done!");
  }
}