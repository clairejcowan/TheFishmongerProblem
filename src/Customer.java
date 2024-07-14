import java.util.Date;
import java.util.Random;

public class Customer extends Thread{
	private FishmongerShop shop, otherShop;
	private Random random;

	public Customer(FishmongerShop shop1, FishmongerShop shop2) {
		shop = shop1;
		otherShop = shop2;
		random = new Random();
	}

	public void run(){
		for(int i=120;i>0;i--){
			// Time of customer i's arrival is recoded in the shop
			// can be used to compute service times for each customer
			Date time = new Date();
			
			//random shop pick
			boolean shopChoice = random.nextBoolean();
			if(shopChoice && !shop.isShopFull())
				shop.enter(time);
			else if (shopChoice && shop.isShopFull())
				otherShop.enter(time);
			else if (!shopChoice && !otherShop.isShopFull())
				otherShop.enter(time);
			else
				shop.enter(time);


			try{
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

}
