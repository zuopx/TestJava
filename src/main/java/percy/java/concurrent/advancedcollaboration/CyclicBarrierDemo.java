/**
 * 
 */

package percy.java.concurrent.advancedcollaboration;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 */
public class CyclicBarrierDemo {

  static class Tourist extends Thread {

    private CyclicBarrier cyclicBarrier;

    public Tourist(CyclicBarrier cyclicBarrier) {
      this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
        Thread.sleep((int) (Math.random() * 1000));
        cyclicBarrier.await();
        System.out.println(this.getName() + " arrived A " + System.currentTimeMillis());
        Thread.sleep((int)(Math.random()*1000));
        cyclicBarrier.await();
        System.out.println(this.getName() + " arrived B " + System.currentTimeMillis());
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    int num = 3;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new Runnable(){
    
      @Override
      public void run() {
        System.out.println("All arrived " + System.currentTimeMillis() + " executed by " + Thread.currentThread().getName());
      }
    });

    for (int i = 0; i < num; i++) {
      new Tourist(cyclicBarrier).start();
    }
  }
}