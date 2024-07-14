import java.util.Random;

public class Fishmonger extends Thread{
	private FishmongerShop shop1, shop2;
	private Random random;
	private String fishmongerName;

	public Fishmonger(String name, FishmongerShop main, FishmongerShop other) {
		fishmongerName = name;
		shop1 = main;
		shop2 = other;
		random = new Random();
	}

	public void run(){
		for(int i=0;i<120;i++){
			while (!shop1.isShopEmpty()){
				shop1.serveCustomer();
				shop1.updateIsResting(false);
			}

			//while shop1 is empty, fishmonger helps shop2
			while (shop1.isShopEmpty() && !shop2.isShopEmpty()){
				System.out.println(shop1.getShopName() + " is empty. " + fishmongerName + " is helping " + shop2.getShopName());
				shop2.serveCustomer();
			}

			//while both shops are empty, fishmongers rest
			if(shop1.isShopEmpty() && shop2.isShopEmpty()){
				System.out.println("Fishmongers are resting...");
				shop1.updateIsResting(true);
				shop2.updateIsResting(true);
			}

			try{
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

}
