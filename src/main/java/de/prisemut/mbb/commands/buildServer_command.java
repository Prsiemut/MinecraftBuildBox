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
        //mbb BS [send | license] <msg>;

        if(args.length >= 2 && args.length <= 3) {
            if (args[1].equals("send")) {
                if (args.length == 3) {
                    tcpClient.send(args[2]);
                    messages.sendMessage("Tryed to send the message to server!");
                } else {
                    messages.sendMessage("Please enter a Message to!");
                }
            } else if (args[1].equals("license")) {
                tcpClient.send("Player asking for permissions!");
            } else {
                messages.sendMessage(usage());
            }
        } else {
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



