package percy.javanut6.ch05.burritos;


public class BurritoMain {

    private static BurritoMain instance = null;

    // Standard void constructor
    public BurritoMain() {
        super();
    }

    /*
     */
    private void run() {
        // SuperBurrito superBurrito = new SuperBurrito();
        // Guacamole guacamole = new Guacamole(superBurrito);
        // Burrito lunch = new Jalapeno(guacamole);
        Burrito lunch = new Jalapeno(new Guacamole(new SuperBurrito()));
        System.out.println("Lunch cost: " + lunch.getPrice());
    }

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) {
        instance = new BurritoMain();
        instance.run();
    }

}
