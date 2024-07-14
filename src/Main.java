public class Main {

    public static void main(String[] args) {
        FishmongerShop shop = new FishmongerShop();

        Fishmonger fishmongerThread = new Fishmonger(shop);
        Customer customerThread = new Customer(shop);

        fishmongerThread.start();
        customerThread.start();
    }

}
