import java.util.*;

public class Customer {

	public Customer(FishmongerShop q) {
		shop = q;
		random = new Random();
	}

	public void enterShop(){
		int i;
		for(i=120;i>0;i--){
			// Time of customer i's arrival is recoded in the shop
			// can be used to compute service times for each customer
			Date time = new Date();
			shop.enter(time);
			try{
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e){System.out.println(e.getMessage());}

		}
	}

	private FishmongerShop shop;
	private Random random;
}
