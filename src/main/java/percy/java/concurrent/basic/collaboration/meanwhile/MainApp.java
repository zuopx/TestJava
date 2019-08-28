/**
 * 
 */

package percy.java.concurrent.basic.collaboration.meanwhile;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) throws InterruptedException {
    FireFlag fireFlag = new FireFlag();
    int num = 10;
    Thread[] racers = new Thread[num];
    for (int i = 0; i < num; i++) {
      racers[i] = new Racer(fireFlag);
      racers[i].start();
    }
    Thread.sleep(1000);
    fireFlag.fire();
  }
}