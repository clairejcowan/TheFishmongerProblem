import java.util.ArrayList;
import java.util.Random;

public class FishmongerShop {
    private ArrayList<Object> w;
    private final int MAX_CAPACITY = 4;
    private String shopName;
    private boolean isResting = true;

    public FishmongerShop(String name) {
        shopName = name;
        w = new ArrayList<Object>();
    }

    public synchronized void enter(Object item) {
        while (w.size() == MAX_CAPACITY) {
            System.out.println(shopName + " is full. Customer waiting outside...");
            try{
                //block enter
                wait();
            }
            catch(InterruptedException e){
                System.out.println("Enter Interrupt Error: " + e);
            }
        }

        //log new customer
        System.out.println("New Customer. " + shopName + " had " + w.size() + " customers waiting.");
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
        while (w.isEmpty()) {
            System.out.println(shopName + " is empty.");
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
            System.out.println("Customer rang " + shopName + "'s bell. Fishmonger is awake.");

        //serve customer
        System.out.println("Fishmonger serving." + shopName + " had " + w.size() + " customers waiting.");
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

    public boolean isShopFull(){
        return w.size() == MAX_CAPACITY;
    }
    public boolean isShopEmpty(){
        return w.isEmpty();
    }
    public String getShopName(){
        return this.shopName;
    }
    public void updateIsResting(boolean state){
        this.isResting = state;
    }

}
