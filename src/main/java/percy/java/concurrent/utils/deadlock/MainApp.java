/**
 * 
 */

package percy.java.concurrent.utils.deadlock;

import java.util.Random;

import percy.java.concurrent.utils.deadlock.AccountMgr.NoEnoughMoneyException;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    // simulateDeadlock();
    simulateTransfer();

  }

  private static void simulateDeadlock() {
    final int accountNum = 10;
    final Account[] accounts = new Account[accountNum];
    final Random rnd = new Random();
    for (int i = 0; i < accountNum; i++) {
      accounts[i] = new Account(rnd.nextInt(10000));
    }
    int threadNum = 100;
    Thread[] threads = new Thread[threadNum];

    for (int i = 0; i < threadNum; i++) {
      threads[i] = new Thread() {
        public void run() {
          int loopNum = 100;
          for (int k = 0; k < loopNum; k++) {
            int i = rnd.nextInt(accountNum);
            int j = rnd.nextInt(accountNum);
            int money = rnd.nextInt(10);
            if (i != j) {
              try {
                System.out.printf("%s before tranfer between %d and %d\n", Thread.currentThread().getName(), i, j);
                AccountMgr.unsafeTransfer(accounts[i], accounts[j], money);
                System.out.printf("%s after tranfer between %d and %d\n", Thread.currentThread().getName(), i, j);
              } catch (NoEnoughMoneyException e) {
                e.printStackTrace();
              }
            }
          }
        }
      };
      threads[i].start();
    }
  }

  private static void simulateTransfer() {
    final int accountNum = 3;
    final Account[] accounts = new Account[accountNum];
    final Random rnd = new Random();
    for (int i = 0; i < accountNum; i++) {
      accounts[i] = new Account(rnd.nextInt(10000));
    }
    int threadNum = 10;
    Thread[] threads = new Thread[threadNum];

    for (int i = 0; i < threadNum; i++) {
      threads[i] = new Thread() {
        public void run() {
          int loopNum = 5;
          for (int k = 0; k < loopNum; k++) {
            int i = rnd.nextInt(accountNum);
            int j = rnd.nextInt(accountNum);
            int money = rnd.nextInt(10);
            if (i != j) {
              try {
                System.out.printf("%s before tranfer between %d and %d\n", Thread.currentThread().getName(), i, j);
                AccountMgr.transfer(accounts[i], accounts[j], money);
                System.out.printf("%s after tranfer between %d and %d\n", Thread.currentThread().getName(), i, j);
              } catch (NoEnoughMoneyException e) {
                e.printStackTrace();
              }
            }
          }
        }
      };
      threads[i].start();
    }
  }
}