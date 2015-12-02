package Server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import engine.testObject;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server implements Runnable{

	protected int          serverPort   = 9000;
	protected ServerSocket serverSocket = null;
	protected boolean      isStopped    = false;
	protected Thread       runningThread= null;

	public Server(int port){
		this.serverPort = port;
	}

	public void run(){
		synchronized(this){
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		while(! isStopped()){
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if(isStopped()) {
					System.out.println("Server Stopped.") ;
					return;
				}
				throw new RuntimeException(
						"Error accepting client connection", e);
			}
			System.out.println("A Client is connected. Creating a Thread for the client");
			new Thread(
					new WorkerRunnable(
							clientSocket, "Multithreaded Server")
					).start();
		}
		System.out.println("Server Stopped.") ;
	}


	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop(){
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port 8080", e);
		}
	}

	public static void main(String[] args){
		Server server = new Server(9000);
		new Thread(server).start();
		while(true){
			
		}
		/*
		try {
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Stopping Server");
		server.stop();
		Server.main(null);
		*/
	}
}
/*
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
 */