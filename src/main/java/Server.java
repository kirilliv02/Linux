import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {

        final int PORT = 1303;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

                String date = dateFormat.format(new Date());

                dos.write(date.getBytes());
                dos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
