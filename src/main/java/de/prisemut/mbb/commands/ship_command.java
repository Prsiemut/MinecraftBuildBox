package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.debug.DebugManager;
import de.prisemut.mbb.shiptool.ShipManager;
import de.prisemut.mbb.shiptool.ShipTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ship_command implements CommandInterface {


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        Messages messages = new Messages(player);
        //mbb ship [type]
        if(args.length == 2) {
            ShipManager shipManager;

            if (args[1].equals("oldp") || args[1].equals("old") || args[1].equals("pirate")) {
                try {
                    shipManager = new ShipManager(ShipTypes.OLD_PIRAT, player, player.getLocation());
                    shipManager.createShip();
                    messages.sendMessage("Created ship successfully!");
                } catch (Exception e) {
                    DebugManager.debug(player, "Error while creating your ship: "+e.getMessage());
                }
            } else if (args[1].equals("modern") || args[1].equals("modernwar") || args[1].equals("war")) {
                try{
                    shipManager = new ShipManager(ShipTypes.MODERN_WARSHIP, player, player.getLocation());
                    shipManager.createShip();
                    messages.sendMessage("Created ship successfully!");
                } catch (Exception e) {
                    DebugManager.debug(player, "Error while creating your ship: "+e.getMessage());
                }
            } else {
                DebugManager.debug(player, "Can`t find your ship type!");
                messages.sendMessage("Please choose [old | modern]!");
            }
        } else {
            messages.sendMessage(usage());
        }
    }

    @Override
    public String usage() {
        return "ship [modern | old]";
    }

    @Override
    public String info() {
        return "Tool for helping with building ships.";
    }
}
