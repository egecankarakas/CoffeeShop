package Server;

public class Shop {
	
	public Double balance;
	public Double [] prices;
	public int [] dailySales;
	public String id;
	public int day;
	
	public Shop(String id){
		balance = 100.0;
		day = 0;
		dailySales = new int[14];
		prices = new Double[14];
		this.id = id;
	}
	
	public void balanceUpdater() {
		balance = balance + prices[day] * 3;
		dailySales[day] = 3;
		day++;
	}
	
}