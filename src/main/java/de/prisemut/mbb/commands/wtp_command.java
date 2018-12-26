package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class wtp_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        Messages messages = new Messages(player);
        if(args.length == 2) {
            World world = Bukkit.getWorld(args[1]);
            player.teleport(world.getSpawnLocation());
            messages.sendMessage("Teleported to world "+args[1]);
        } else {
            messages.sendMessage("Please just use /mbb wtp [NAME]");
        }
    }

    public String usage() {
        return null;
    }

    public String info() {
        return null;
    }
}
