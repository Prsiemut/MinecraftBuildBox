package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.shiptool.ShipManager;
import de.prisemut.mbb.shiptool.ShipTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ship_command implements CommandInterface{


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);
        //mbb ship [old | modern]
        if(args.length == 2) {
            if(args[1].equals("old")) {
                ShipManager shipManager = new ShipManager(player.getLocation());
                shipManager.buildShip(player.getWorld());
                messages.sendMessage("Created ship!");
            } else if (args[1].equals("modern")) {
                messages.sendMessage("Not avaible yet!");
            } else {
                messages.sendMessage("old and modern are the only types!");
            }
        } else {
            messages.sendMessage(usage());
        }
    }

    @Override
    public String usage() {
        return "ship [old | modern]";
    }

    @Override
    public String info() {
        return "Will create a ship ground plan!";
    }
}
