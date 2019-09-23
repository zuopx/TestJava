package percy.java.generics;

/**
 * ClassCastExceptionDemo
 */
public class ClassCastExceptionDemo {

  public static void main(String[] args) {
    Pair pair = new ClassCastExceptionDemo().new Pair("Java", 8);

    //! ClassCastException
    // The fields in inner class are accesible to outer class directly.
    Integer first = (Integer) pair.first;
    Integer second = (Integer) pair.second;

    System.out.println(first);
    System.out.println(second);

    System.out.println("Done!");
  }

  /**
   * Pair
   */
  class Pair {
  
    private Object first;
    private Object second;

    public Pair(Object first, Object second) {
      this.first = first;
      this.second = second;
    }
    
  }
}