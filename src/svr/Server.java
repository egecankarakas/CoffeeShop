package svr;

import java.net.*;
import java.io.*;

public class Server {

	static ServerSocket socket1;
	protected final static int port = 19999;
	static Socket connection;
	static boolean first;
	static StringBuffer process;

	public static void main(String[] args) throws Exception {

		try{
			socket1 = new ServerSocket(port);
			System.out.println("Server running");

			while (true) {
				connection = socket1.accept();
				receiveMessage();
				sendMessage();
				disconnect();
			}
		}
		catch (IOException e) {}

	}

	public static void receiveMessage() throws Exception{
		int character;
		BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
		InputStreamReader isr = new InputStreamReader(is);
		process = new StringBuffer();
		while((character = isr.read()) != 13) {
			process.append((char)character);
		}
		System.out.println(process);

	}

	public static void sendMessage() throws Exception{
		String returnCode = "Server message"+ (char) 13;
		BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
		OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
		osw.write(returnCode);
		osw.flush();
	}

	public static void disconnect() throws Exception{
		connection.close();
	}

}