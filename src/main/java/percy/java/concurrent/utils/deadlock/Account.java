/**
 * When operating on an account, it must be locked. How to lock an account?
 * Use an inner lock to delegate. 
 */

package percy.java.concurrent.utils.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Account
 */
public class Account {
  private volatile double money;
  private Lock lock = new ReentrantLock();

  public Account(double money) {
    this.money = money;
  }

  public void add(double money) {
    lock();
    try {
      this.money  += money;
      // System.out.println("add money " + money);
    } finally {
      unlock();
    }
  } 
  
  public void reduce(double money) {
    lock();
    try {
      this.money -= money;
      // System.out.println("reduce money " + money);
    } finally {
      unlock();
    }
  }

  public double getMoney() {
    return money;
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

  public boolean tryLock() {
    return lock.tryLock();
  }
}