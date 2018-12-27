package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.world.WorldManager;
import de.prisemut.mbb.world.WorldTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public class wcreate_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        Messages m = new Messages(player);
        //mbb wcreate name type l1 l2
        if(args.length >= 3 && args.length <= 5) {
            WorldManager worldManager;
            if(args[2].equalsIgnoreCase("flat")) {
                worldManager = new WorldManager(args[1], WorldTypes.FLAT);
                worldManager.createWorld();
                m.sendMessage("Created world " + args[1] + " successfully!");
            } else if (args[2].equalsIgnoreCase("mf")) {
                worldManager = new WorldManager(args[1], WorldTypes.MF);
                worldManager.createWorld();
                m.sendMessage("Created world " + args[1] + " successfully!");
            } else if (args[2].equalsIgnoreCase("mf+")) {
                worldManager = new WorldManager(args[1], WorldTypes.MFP);
                worldManager.createWorld();
                m.sendMessage("Created world " + args[1] + " successfully!");
            } else if (args[2].equalsIgnoreCase("cwc")) {
                worldManager = new WorldManager(args[1], Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                worldManager.createCoustomWorld();
                m.sendMessage("Created coustom world "+args[1]+ " successfully!");
            }
        }else{
            m.sendMessage(usage());
        }
    }

    public String usage() {
        return "wcreate [Name] [FLAT, MF, MF+ or cwc] <for cwc: (Layer1 e.g. BedrockID: 7) (Layer2 e.g. GrassID: 2)>";
    }

    public String info() {
        return "Command for creating worlds!";
    }
}
