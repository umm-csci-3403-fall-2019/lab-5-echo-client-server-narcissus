package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNum = 6103;

    public static void main(String[] args) {
        try {
            // Start listening a la NSA on the selected port
            ServerSocket socket = new ServerSocket(portNum);

            // Run forever, common for both servers and me from my problems
            while (true) {
                // Wait until someone connects
                Socket client = socket.accept();
                System.out.println("Got a request!");

                // construct a writer so we can write to the socket,
                // thereby sending something back to the client.
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                // Send current date back

                writer.println(new java.util.Date().toString());

                // Close it politely like you should with sockets and doors
                client.close();
            }

        }
        catch (IOException ioe) {
            System.out.println("We caught an unexpected exception! OWO");
            System.err.println(ioe);
        }

    }
}