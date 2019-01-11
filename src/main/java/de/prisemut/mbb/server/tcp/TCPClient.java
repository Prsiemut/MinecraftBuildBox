package de.prisemut.mbb.server.tcp;

import de.prisemut.mbb.*;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

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
        runThread.stop();
        runThread.interrupt();
    }

    public void send(String msg){
        try {
            if(socket == null) return;

            msgToServer = new PrintWriter(socket.getOutputStream());

            msgToServer.write(msg +"\n");
            msgToServer.flush();
        }
        catch (Exception ex){
            System.out.println("[MBB] Error on sending Message to Server!");
        }
    }

    public void Connect() {
        try {
            InetAddress host = InetAddress.getByName("localhost"); //TODO: Enter the final host, not sure wich Server I will use atm
            System.out.println("[MBB] Connecting to Server... ");
            socket = new Socket(host, serverPort);
            System.out.println("[MBB] Successfully connected to Server!");
            runThread.start();
        }
        catch (Exception ex){


        }
    }

    private boolean enabled(){
        File f = new File(MinecraftBuildingBox.getInstance().getDataFolder() + "/tcp/" +"TCP.Client");
        if(!f.exists()){
            System.out.println("[MBB] Disable TCP Client...");
                 closing = true;
return false;
                   }
        else{
            return true;
        }
    }

    Thread runThread = new Thread(){
    public void run() {


        try {
            msgFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (closing == true|| !isInterrupted() || enabled() == true) {
                String line = msgFromServer.readLine();
                if (line != null && line.length() > 0) {
                    if (handler != null) handler.onMessage(line);
                }
            }
            // msgToServer.println("[0xGERND]");
            // String line = msgFromServer.readLine();
            // System.out.println("Client Received: " + line + " from " + host);
            msgToServer.close();
            msgFromServer.close();
            socket.close();
        } catch (
                UnknownHostException ex) {
            ex.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
      }
    };


    /*
    Methods to send and receive schematic files!
     */
    public void sendSchematicFile(String schematicfile) throws IOException {
        File file = new File("MUST DEFINE A FOLDER LATER ON");
        OutputStream out = socket.getOutputStream();
        InputStream fileIn = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        while (fileIn.available() > 0) {
            out.write(buffer, 0, fileIn.read(buffer));
        }

        fileIn.close();
    }

    public void receiveSchematicFile(String schematicfile) throws IOException {
        InputStream in = socket.getInputStream();
        FileOutputStream fileOut = new FileOutputStream("MUST DEFINE FILE AND FOLDER LATER ON");

        byte[] buffer = new byte[1024];
        while (socket.isConnected()) {
            int bytesRead = in.read(buffer);
            if (bytesRead == -1) break;
            fileOut.write(buffer, 0, bytesRead);
        }

        fileOut.close();
    }

}
