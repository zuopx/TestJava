/**
 * 
 */

package percy.java.concurrent.basic.collaboration.assemblepoint;

/**
 * MainApp
 */
public class MainApp {

  static class Tourist extends Thread {
    private AssemblePoint assemblePoint;

    @Override
    public void run() {
      try {
        Thread.sleep((int) Math.random() * 1000);
        System.out.println("Before assemble " + Thread.currentThread().getName());
        assemblePoint.await();
        Thread.sleep((int) Math.random() * 1000);
        System.out.println("After assemble " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public Tourist(AssemblePoint assemblePoint) {
      this.assemblePoint = assemblePoint;
    }
  }

  public static void main(String[] args) {
    int num = 10;
    AssemblePoint assemblePoint = new AssemblePoint(num);
    Thread[] tourists = new Thread[num];
    for (int i = 0; i < num; i++) {
      tourists[i] = new Tourist(assemblePoint);
      tourists[i].start();
    }
  }
}