package Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

    public static void main(String[] args) throws IOException {
        Teacher teacher = new Teacher();
    	
    	int MAXCLIENTS = 20;
        int port = 4444;
        ServerSocket server = null;
        Socket clientSocket = null;
        // An array of clientsConnected instances
        ClientThread[] clientsConnected = new ClientThread[MAXCLIENTS];
        

        try {
            server = new ServerSocket(port);
            System.out.println("listening on port: " + port);
        } catch (IOException e) {// TODO Auto-generated catch block
            e.printStackTrace();

        }

        while (true) {
            try {
                clientSocket = server.accept();

            } catch (IOException e) {
                e.printStackTrace();
                if (!server.isClosed()){server.close();}
                if (!clientSocket.isClosed()){clientSocket.close();}
            }
            
            System.out.println("Client connected!");

            for (int c = 0; c < clientsConnected.length; c++){
                if (clientsConnected[c] == null){
                    // if it is empty ( null) then start a new Thread, and pass the socket and the object of itself as parameter
                    (clientsConnected[c] = new ClientThread(clientSocket, clientsConnected,teacher)).start();
                    break; // have to break, else it will start 20 threads when the first client connects :P
                }
            }
        }

    }
}