package clnt;
import java.net.*;
import java.io.*;


public class Client {
	static String host = "localhost";
	static int port = 19999;
	static Socket connection;
	static InetAddress address;

	public static void main(String[] args) throws Exception {

		System.out.println("Client is running.");
		connect();
		sendMessage();
		receiveMessage();
		disconnect();

	}

	public static void connect() throws Exception  {
		address = InetAddress.getByName(host);
		connection = new Socket(address, port);
	}

	public static void disconnect() throws Exception{
		connection.close();
	}

	public static void sendMessage() throws Exception{

		BufferedOutputStream bos = new BufferedOutputStream(connection.
				getOutputStream());

		OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
		String process = "Client message" +  (char) 13;

		osw.write(process);
		osw.flush();

	}

	public static void receiveMessage() throws Exception{

		StringBuffer instr = new StringBuffer();
		BufferedInputStream bis = new BufferedInputStream(connection.
				getInputStream());

		InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

		int c;
		while ( (c = isr.read()) != 13)
			instr.append( (char) c);

		System.out.println(instr);


	}

}
