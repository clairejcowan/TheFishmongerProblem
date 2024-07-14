import java.util.ArrayList;
import java.util.Random;

public class FishmongerShop {
    private ArrayList<Object> w;
    private final int MAX_CAPACITY = 4;

    public FishmongerShop() {
        w = new ArrayList<Object>();
    }

    public synchronized void enter(Object item) {
        while (w.size() == MAX_CAPACITY) {
            System.out.println("Shop is full. Customer waiting outside...");
            try{
                //block enter
                wait();
            }
            catch(InterruptedException e){
                System.out.println("Enter Interrupt Error: " + e);
            }
        }

        //log new customer
        System.out.println("New Customer. Shop had " + w.size() + " customers waiting.");
        w.add(item);

        try{
            //random execution delay
            Thread.sleep(new Random().nextLong(500));
        }
        catch (InterruptedException e){
            System.out.println("Enter Sleep Interrupt Error: " + e);
        }

        //notify serveCustomer
        notify();
    }

    public synchronized Object serveCustomer() {
        boolean isResting = false;

        while (w.size() == 0) {
            System.out.println("Shop is empty. Fishmonger resting...");
            isResting = true;
            try {
                //block serveCustomer
                wait();
            }
            catch (InterruptedException e){
                System.out.println("Serve Customer Interrupt Error: " + e);
            }
        }

        //wake up fishmonger
        if(isResting)
            System.out.println("Customer rang the bell. Fishmonger is awake.");

        //serve customer
        System.out.println("Fishmonger serving. Shop had " + w.size() + " customers waiting.");
        Object item = w.get(0);
        w.remove(0);

        try{
            //Random execution delay
            Thread.sleep(new Random().nextLong(500));
        }
        catch (InterruptedException e){
            System.out.println("Serve Customer Sleep Interrupt Error: " + e);
        }

        //notify enter
        notify();
        return item;
    }

}
