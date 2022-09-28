import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)  {


        Scanner sc = new Scanner(System.in);
        System.out.println("Host: ");
        String host = sc.nextLine();

        try (Socket socket = new Socket(host, 1303)) {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String response = new String(dis.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(response);

            dis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
