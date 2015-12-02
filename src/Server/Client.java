package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client  
{
	public static void main(String[] args) throws IOException {

		Client m = new Client();
		m.connect();
	}

	public void connect() throws IOException{
		

		// localhost ip
		String ip = "127.0.0.1";
		int port = 4444;
		Socket socket = null;

		
		try {

			//connect
			socket = new Socket(ip, port);

			//initialize streams
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			//start a thread which will start listening for messages
			//new ReceiveMessage(in).start();

			// send the name to the server!
			//out.writeUTF(name);
			
			Shop shop = new Shop("Erdi");
			shop.day = 1;
			System.out.println(shop.id+"'s shop's day before sending is : "+shop.day);
			System.out.println("Trying to send "+shop.id+"'s shop to the Server.");
			out.writeObject(shop);
			System.out.println("Sent "+shop.id+"'s shop to the Server.");
			shop = (Shop) in.readObject();
			System.out.println("Read "+shop.id+"'s shop from the Server.");
			
			System.out.println(shop.id+"'s shop's day after receiving is : "+shop.day);

			/*
			while (true){
				//Write messages :)
				String message = keyboard.nextLine();
				out.writeUTF(message);
			}
			*/
			in.close();
			out.close();

		}
		catch (IOException e){
			e.printStackTrace();
			if (!socket.isClosed()){socket.close();}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ReceiveMessage extends Thread{

		DataInputStream in;

		ReceiveMessage(DataInputStream in){
			this.in = in;
		}

		public void run(){
			String message;
			while (true){
				try {
					message = in.readUTF();
					System.out.println(message);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}

}