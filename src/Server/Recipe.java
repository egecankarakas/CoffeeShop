package Server;
import java.io.Serializable;

public class Recipe implements Serializable{
	
	private static final long serialVersionUID = 7526472295622776150L;
	
	int coffeePerCup;
	int milkPerCup;
	int sugarPerCup;
	
	public Recipe(int coffeePerCup, int milkPerCup, int sugarPerCup){
		this.coffeePerCup = coffeePerCup;
		this.milkPerCup = milkPerCup;
		this.sugarPerCup = sugarPerCup;
	}
	
}
