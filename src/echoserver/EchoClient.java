package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
    public static final int portNum = 6013;

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
            OutputStream out = socket.getOutputStream();

            // get inputstream
            InputStream inputStream = socket.getInputStream();

            int temp;
            int line;
            while ((line = System.in.read()) != -1) {
                out.write(line);
                temp = inputStream.read();
                System.out.write(temp);

            }
            out.flush();
            System.out.flush();
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