import java.util.*;

public class Fishmonger extends Thread{
	private FishmongerShop shop;
	private Random random;

	public Fishmonger(FishmongerShop q) {
		shop = q;
		random = new Random();
	}

	public void run(){
		for(int i=0;i<120;i++){
			shop.serveCustomer();
			try{
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

}
