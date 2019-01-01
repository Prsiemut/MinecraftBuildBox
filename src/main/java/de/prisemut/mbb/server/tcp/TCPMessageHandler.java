package de.prisemut.mbb.server.tcp;
import de.prisemut.mbb.Messages;
import org.bukkit.*;

import java.io.*;

public class TCPMessageHandler {



    public void onMessage(String msg){

        Bukkit.broadcastMessage(msg);
    }
}
