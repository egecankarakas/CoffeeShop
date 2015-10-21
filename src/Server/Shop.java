package Server;

public class Shop {
	
	public Double balance;
	public Double [] prices;
	public int [] dailySales;
	public String id;
	public int day;
	public Inventory inventory;
	public Recipe[] recipes;
	public inventoryPriceTable priceTable = new inventoryPriceTable();
	
	public Shop(String id){
		balance = 100.0;
		day = 0;
		dailySales = new int[14];
		prices = new Double[14];
		this.id = id;
		this.recipes = new Recipe[14];
		this.inventory = new Inventory(5,10.0,15.0,20.0);
	}
	
	public void balanceUpdater() {
		balance = balance + prices[day] * 3;
		dailySales[day] = 3;
		day++;
	}
}