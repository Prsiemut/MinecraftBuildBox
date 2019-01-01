package de.prisemut.mbb.commands;

import de.prisemut.mbb.*;
import de.prisemut.mbb.world.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import de.prisemut.mbb.server.tcp.TCPClient;

public class buildServer_command implements CommandInterface {

    TCPClient tcpClient = new TCPClient();


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);

        if(args[1].equals("BS")){
            if(args[3].equals("send")) {
                if(args.length == 4) {
                    tcpClient.send(args[4]);
                    messages.sendMessage("try to send message to server");
                }
                else {
            messages.sendMessage("Please enter a Message to!");
                }
            }

        } else if(args[1].equals("License")) {

            messages.sendMessage("Not implementet yet");
        }
         else {
            messages.sendMessage(usage());
        }

    }

    @Override
    public String usage() {
        return "BuildServer Usage: BS send <message> for sending message to Server";
    }

    @Override
    public String info() {
        return "For your projects!";
    }
}



