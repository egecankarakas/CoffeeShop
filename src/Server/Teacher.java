package Server;

public class Teacher {
	
	public void readFromClient(String str){
		System.out.println("The price entered by the Client: " +str);
		//Firstly we need to control the price entered as a readable Integer or
		//some other String like "asdf". I will evalute unreadable strings as 0
		
		Double price = 0.0;
		try {
			price = Double.parseDouble(str);
		}catch(java.lang.NumberFormatException ne){
			System.out.println("Illegat format exception Caught. Price Set to 0.0");
		}
		System.out.println("Price readed is :" +price);
		
		//For a starting point I will...
	}
	
}
