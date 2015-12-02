package Server;
import java.io.Serializable;

public class Inventory implements Serializable{
	
	private static final long serialVersionUID = 7526472295622776148L;
	
	public int cups;
	public double coffee;
	public double milk;
	public double sugar;
	
	public Inventory(int cups, double coffee, double milk, double sugar){
		this.cups = cups;
		this.coffee = coffee;
		this.milk = milk;
		this.sugar = sugar;
	}
}
