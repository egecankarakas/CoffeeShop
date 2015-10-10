package Server;

public class Recipe {
	private Double coffeePerCup;
	private Double milkPerCup;
	private Double sugarPerCup;
	private Double priceOfOneCup;
	
	public Recipe(Double coffeePerCup, Double milkPerCup, Double sugarPerCup, Double priceOfOneCup){
		this.coffeePerCup = coffeePerCup;
		this.milkPerCup = milkPerCup;
		this.sugarPerCup = sugarPerCup;
		this.priceOfOneCup = priceOfOneCup;
	}

	public Double getCoffeePerCup() {
		return coffeePerCup;
	}

	public Double getMilkPerCup() {
		return milkPerCup;
	}

	public Double getSugarPerCup() {
		return sugarPerCup;
	}

	public Double getPriceOfOneCup() {
		return priceOfOneCup;
	}
}
