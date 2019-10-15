package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
    public static final int portNum = 6103;

    public static void main(String[] args) {
        String server;
        // Use 127.0.0.1 aka localhost
        if (args.length == 0) {
            server = "127.0.0.1";
        }
        else {
            server = args[0];
        }
        try {
            // connect to server
            Socket socket = new Socket(server, portNum);

            // get inputstream
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // print input
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            //close socket

            socket.close();

        }
        catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        }
        catch (IOException ioe) {
            System.out.println("We caught an unexpected exception.");
            System.err.println(ioe);
        }
    }
}