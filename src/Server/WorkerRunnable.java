package Server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

/**

 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(input);
            Shop shop = (Shop) ois.readObject();
            System.out.println("Shop is read with shop id: "+shop.id);
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(output);
            oos.writeObject(shop);
            long time = System.currentTimeMillis();
            //output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +this.serverText + " - " +time +"").getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
