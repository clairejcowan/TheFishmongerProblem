import java.util.ArrayList;

public class FishmongerShop {
    private ArrayList<Object> w;
    private final int MAX_CAPACITY = 4;

    public FishmongerShop() {
        w = new ArrayList<Object>();
    }

    public synchronized void enter(Object item) {
        if (w.size() == MAX_CAPACITY)
            System.out.println("Maximum capacity reached. Customer leaving.");
        else {
            System.out.println("New Customer. Shop had " + w.size() + " customers waiting.");
            w.add(item);
            if (w.size() == 1)
                System.out.println("Customer has rang the bell. Fishmonger is awake.");
        }
    }

    public synchronized Object serveCustomer() {
        Object item = null;

        if (w.size() == 0)
            System.out.println("Shop is empty. Fishmonger resting...");
        else {
            System.out.println("Fishmonger serving. Shop had " + w.size() + " customers waiting. ");
            item = w.get(0);
            w.remove(0);
        }
        return item;
    }

}
