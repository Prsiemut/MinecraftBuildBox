package de.prisemut.mbb.server.tcp;

import java.io.*;
import java.net.Socket;
import java.net.*;
import java.util.concurrent.TimeoutException;


public class TCPClient {

    boolean closing = false;
    private TCPMessageHandler handler;
    private Socket socket;
    private int serverPort = 5001; //I think that was the port :D
    private BufferedReader msgFromServer;
    private  PrintWriter msgToServer;

    public void close(){

        closing = true;
    }

    public void send(String msg){
        try {
            if(socket == null) return;

            msgToServer = new PrintWriter(socket.getOutputStream());

            msgToServer.write(msg +"\n");
            msgToServer.flush();
        }
        catch (Exception ex){
System.out.println("Error on sending Message to Server");
        }
    }

    public void Connect() {
        try {
            InetAddress host = InetAddress.getByName("localhost"); //TODO: Enter the final host, not sure wich Server I will use atm
            System.out.println("Connecting to Server... ");
            socket = new Socket(host, serverPort);
            System.out.println("Successfully connected to Server");
        }
        catch (Exception ex){


        }
    }

    public void run(){

        try{
             msgFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (!closing) {
                String line = msgFromServer.readLine();
                if(line != null && line.length() >0){
                    if(handler !=null) handler.onMessage(line);
                }
            }
           // msgToServer.println("[0xGERND]");
           // String line = msgFromServer.readLine();
           // System.out.println("Client Received: " + line + " from " + host);
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
