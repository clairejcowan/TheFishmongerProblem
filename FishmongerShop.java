
import java.util.ArrayList;

public class FishmongerShop {

	public FishmongerShop() {
		w= new ArrayList<Object>();
	}

	public void enter(Object item) {
		System.out.println("New Customer. Shop had " + w.size() + " customers waiting. ");
		w.add(item);
	}

	public Object serveCustomer(){
		Object item = null;
		if(w.size()==0) System.out.println("Shop is empty");
		else {
			System.out.println("Fishmonger serving. Shop had " + w.size() + " customers waiting. ");
			item = w.get(0);
			w.remove(0);
		}
		return item;
	}

	private ArrayList<Object> w;

}
