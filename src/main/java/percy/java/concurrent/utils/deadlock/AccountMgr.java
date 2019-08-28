/**
 * 
 */

package percy.java.concurrent.utils.deadlock;

/**
 * AccountMgr
 */
public class AccountMgr {

  public static class NoEnoughMoneyException extends Exception {
  }

  public static void unsafeTransfer(Account from, Account to, double money) throws NoEnoughMoneyException {
    from.lock();
    try {
      to.lock();
      try {
        if (from.getMoney() < money) {
          throw new NoEnoughMoneyException();
        } else {
          from.reduce(money);
          to.add(money);
        }
      } finally {
        to.unlock();
      }
    } finally {
      from.unlock();
    }
  }

  public static void transfer(Account from, Account to, double money) throws NoEnoughMoneyException {
    boolean success = false;
    do {
      success = tryTransfor(from, to, money);
      if (!success) {
        Thread.yield();
      }
    } while (!success);
  }

  private static boolean tryTransfor(Account from, Account to, double money) throws NoEnoughMoneyException {
    if (from.tryLock()) {
      try {
        if (to.tryLock()) {
          try {
            if (from.getMoney() >= money) {
              from.reduce(money);
              to.reduce(money);
              return true;
            } else {
              throw new NoEnoughMoneyException();
            }
          } finally {
            to.unlock();
          }
        }
      } finally {
        from.unlock();
      }
    }
    return false;
  }

}