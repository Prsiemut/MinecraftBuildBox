package de.prisemut.mbb.server.tcp;

import java.io.*;
import java.net.Socket;
import java.net.*;
import java.util.concurrent.TimeoutException;


public class TCPClient {

    public void run(){
        try{
            int serverPort = 5001; //I think that was the port :D
            InetAddress host = InetAddress.getByName("localhost"); //TODO: Enter the final host, not sure wich Server I will use atm
            System.out.println("Connecting to Server... ");
            Socket socket = new Socket(host,serverPort);
            System.out.println("Successfully connected to Server");
            PrintWriter msgToServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader msgFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msgToServer.println("[0xGERND]");
            String line = msgFromServer.readLine();
            System.out.println("Client Received: " + line + " from " + host);
            msgToServer.close();
            msgFromServer.close();
            socket.close();
        }
        catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
