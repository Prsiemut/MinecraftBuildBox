package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public class wlist_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);
        if(args.length == 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for(World world : Bukkit.getWorlds()) {
                stringBuilder.append("§7"+world.getName() + ", ");
            }
            stringBuilder.setLength(stringBuilder.toString().length()-2);
            messages.sendMessage("List of all your worlds:");
            messages.sendMessage(stringBuilder.toString());
        } else {
            messages.sendMessage("Please just use "+usage());
        }
    }

    public String usage() {
        return "wlist";
    }

    public String info() {
        return "will give you a list of all of your loaded world!";
    }
}
