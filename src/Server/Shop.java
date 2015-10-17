package Server;

public class Shop {
	
	private Double Balance;
	private Double Price;
	
	public Shop(){
		Balance = 100.0;
	}
	
	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		Balance = balance;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
}