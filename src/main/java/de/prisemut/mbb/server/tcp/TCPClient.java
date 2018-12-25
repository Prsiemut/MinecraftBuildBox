package de.prisemut.mbb.server.tcp;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void connectToServer() {
        try {
            Socket client = new Socket("localhost", 3333);
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
