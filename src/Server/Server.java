package server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import engine.testObject;

public class Server {
	static Socket connection;
	static ObjectInputStream input;
	static  ServerSocket server;
	public static void main(String[] args){    
		connect();
		testObject a = (testObject) receiveObject();
		System.out.println(a);
	
	}
	public static Object receiveObject() {
		try{
			input = new ObjectInputStream(connection.getInputStream());
			Object obj= null;
			obj = (Object) input.readObject();
			input.close();
			return obj;
		}
		catch(Exception e){
			return "noting";
		}
	}	 

	public static void connect() {
		try{
			server = new ServerSocket(1111);
			connection = server.accept();
		}
		catch(Exception e){}
	}

}
