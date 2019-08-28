/**
 * Producer-Consumer queue.
 */

package percy.java.concurrent.utils.explicitlock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * MyBlockingQueue
 */
public class MyBlockingQueue<E> {

  private Queue<E> queue = null;
  private Integer limit;
  private Lock lock = new ReentrantLock();
  private Condition notFull = lock.newCondition();
  private Condition notEmpty = lock.newCondition();

  public MyBlockingQueue(Integer limit) {
    this.limit = limit;
    queue = new ArrayDeque<>(limit);
  }

  public void put(E e) throws InterruptedException {
    lock.lock();
    try {
      while (queue.size() == limit) {
        notFull.await();
      }
      queue.offer(e);
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  public E take() throws InterruptedException {
    lock.lock();
    try {
      while (queue.isEmpty()) {
        notEmpty.await();
      }
      E e = queue.poll();
      notFull.signal();
      return e;
    } finally {
      lock.unlock();
    }
  }
}