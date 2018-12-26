package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.world.WorldManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class wdelete_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);
        if(args.length == 2) {
            WorldManager.deleteWorld(args[1]);
            messages.sendMessage("Deleted world "+args[1] + " successfully!");
        } else {
            messages.sendMessage("Please just use /mbb wdelete [NAME]");
        }
    }

    public String usage() {
        return "wdelete [NAME]";
    }

    public String info() {
        return "will delete your world!";
    }
}
