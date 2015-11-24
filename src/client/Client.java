package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import engine.testObject;

public class Client {
	static Socket connection;
	static ObjectOutputStream output;
	static ObjectInputStream input;

	public static void main(String[] args) {   

		System.out.println("Creating object");
		testObject obj= new testObject ("Client", "Message");
		System.out.println("Connecting");
		connect();
		System.out.println("Sending");
		sendObject(obj);
		System.out.println("Closing");
		disconnect();

	} 

	public static void connect() {
		try{
			connection = new Socket("127.0.0.1", 1111);
		}
		catch(Exception e){}
	}

	public static void disconnect() {
		try{
			connection.close();
		}
		catch(Exception e){}
	}

	public static void sendObject(Object obj)  {
		try{
			output = new ObjectOutputStream(connection.getOutputStream());
			output.writeObject(obj);
			output.flush();
			output.close();
		}
		catch(Exception e){}
	}

	public static Object receiveObject() {
		try{
			input = new ObjectInputStream(connection.getInputStream());
			Object obj= null;
			obj = (Object) input.readObject();
			return obj;
		}
		catch(Exception e){
			return "noting";
		}
	}

}
