/**
 * 
 */

package percy.java.concurrent.basic.collaboration.producerconsumer;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    MyBlockingQueue<String> queue = new MyBlockingQueue<>(4);
    new Producer(queue).start();
    new Consumer(queue).start();
  }
}