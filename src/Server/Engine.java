package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
public class Engine {
	public void main(String [] args) throws IOException {
		ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
	}
}
