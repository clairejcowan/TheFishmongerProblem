public class Main {

    public static void main(String[] args) {
        FishmongerShop shop1 = new FishmongerShop("shop1");
        FishmongerShop shop2 = new FishmongerShop("shop2");

        Fishmonger fishmongerThread1 = new Fishmonger("Fishmonger1", shop1, shop2);
        Fishmonger fishmongerThread2 = new Fishmonger("Fishmonger2", shop1, shop2);
        Customer customerThread = new Customer(shop1, shop2);

        fishmongerThread1.start();
        fishmongerThread2.start();
        customerThread.start();
    }

}
