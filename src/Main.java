import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (
            Socket mySocket = new Socket("localhost",2000);
            DataInputStream socketIn = new DataInputStream(mySocket.getInputStream());
            DataOutputStream socketOut = new DataOutputStream(mySocket.getOutputStream());

                ){
            socketOut.writeUTF("Hello");
            String response = socketIn.readUTF();
            System.out.println("Recibido "+ response);
        }catch (IOException exception){
            System.err.println(exception);
        }

    }
}