/**
 * Producer-Consumer queue.
 */

package percy.java.concurrent.basic.collaboration.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * MyBlockingQueue
 */
public class MyBlockingQueue<E> {

  private Queue<E> queue = null;
  private Integer limit;

  public MyBlockingQueue(Integer limit) {
    this.limit = limit;
    queue = new ArrayDeque<>(limit);
  }

  public synchronized void put(E e) throws InterruptedException {
    while (queue.size() == limit) {
      wait();
    }
    queue.offer(e);
    notifyAll();
  }

  public synchronized E take() throws InterruptedException {
    while (queue.isEmpty()) {
      wait();
    }
    E e = queue.poll();
    notifyAll();
    return e;
  }
}