package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientThread extends Thread{

    private ClientThread[] clientsConnected;
    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private String clientName = null;
    private Teacher teacher;

    //Constructor
     public ClientThread(Socket socket, ClientThread[] clientsConnected, Teacher teacher){
        this.socket = socket;
        this.clientsConnected = clientsConnected;
        this.teacher = teacher;
    }

    public void run(){
        try {
            // Streams :)
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            String message = null;

            Shop shop = new Shop("Trial Shop");
            
            System.out.println("Trying to read the Shop Object");
            
            shop = (Shop) in.readObject();
            
            
            
            System.out.println("Shop Object is read. Its id is : "+shop.id);
            
            Engine engine = new Engine(teacher);
            
            System.out.println("Engine part is beginning");
            
            engine.updatePlayerList(shop);
            
            System.out.println("Updated player list in teacher gui");
            
            System.out.println("Returning new Shop Object to client");
            
            out.writeObject(shop);
            
            while(true){
            	System.out.println("Hanging here time to time.");
            	sleep(500000);
            	
            }
            
            /*clientName = in.readUTF();

            while (true){
                message = in.readUTF();

                for (int c = 0; c < clientsConnected.length; c++){
                    if (clientsConnected[c]!= null && clientsConnected[c].clientName != this.clientName){ //dont send message to your self ;)
                        clientsConnected[c].sendMessage(message, clientName); // loops through all the list and calls the objects sendMessage method.
                    }
                }

            }
            */

        } catch (IOException e) {
            System.out.println("Client disconnected!");
            this.clientsConnected = null;
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // Every instance of this class ( the client ) will have this method.
    private void sendMessage(String mess, String name){
        try {
            out.writeUTF(name + " says: " + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}