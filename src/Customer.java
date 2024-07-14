import java.util.*;

public class Customer extends Thread{
	private FishmongerShop shop;
	private Random random;

	public Customer(FishmongerShop q) {
		shop = q;
		random = new Random();
	}

	public void run(){
		for(int i=120;i>0;i--){
			// Time of customer i's arrival is recoded in the shop
			// can be used to compute service times for each customer
			Date time = new Date();
			shop.enter(time);
			try{
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

}
