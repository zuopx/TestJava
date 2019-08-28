package percy.java.concurrent.basic.collaboration.mylatch;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) throws InterruptedException {
    // startAtSameTime();
    endAtSameTime();

  }

  private static void startAtSameTime() {
    MyLatch latch = new MyLatch(1);
    int num = 10;
    Thread[] racers = new Thread[num];
    for (int i = 0; i < num; i++) {
      racers[i] = new Racer(latch);
      racers[i].start();
    }
    System.out.println("Start!");;
    latch.countDonw();
  }

  private static void endAtSameTime() throws InterruptedException {
    int num = 10;
    MyLatch latch = new MyLatch(num);
    Thread[] workers = new Thread[num];
    for (int i = 0; i < num; i++) {
      workers[i] = new Worker(latch);
      workers[i].start();
    }
    latch.await();
    System.out.println("Done!");
  }
}