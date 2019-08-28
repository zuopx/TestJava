/**
 * 
 */

package percy.java.concurrent.advancedcollaboration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLockDemo
 */
public class ReadWriteLockDemo {

  private Map<String, Object> map = new HashMap<>();
  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private Lock readLock = readWriteLock.readLock();
  private Lock writeLock = readWriteLock.writeLock();

  public Object get(String key) {
    readLock.lock();
    try {
      return map.get(key);
    } finally {
      readLock.unlock();
    }
  }

  public void put(String key, Object value) {
    writeLock.lock();
    try {
      map.put(key, value);
    } finally {
      writeLock.unlock();
    }
  }

  public void clear() {
    writeLock.lock();
    try {
      map.clear();
    } finally {
      writeLock.unlock();
    }
  }
}