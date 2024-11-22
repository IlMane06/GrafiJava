import java.io.*;
import java.net.*;

public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(12345);
    Socket clientSocket = serverSocket.accept();

    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    String request = in.readLine();
    System.out.println("Ricevuto dal client: " + request);

    out.println("Ciao dal server!");

    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
}