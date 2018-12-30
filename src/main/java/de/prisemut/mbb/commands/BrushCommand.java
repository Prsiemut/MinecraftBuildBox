package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.brush.BrushTypes;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Hashtable;

public class BrushCommand implements CommandInterface{

    public static Hashtable<Player, BrushTypes> edit = new Hashtable<Player, BrushTypes>();
    public static Hashtable<Player, Integer> editSize = new Hashtable<Player, Integer>();

    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);

        if(args[1].equals("cubebrush") || args[1].equals("cb")) {
           if(player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
               edit.put(player, BrushTypes.CUBE_BRUSH);
               editSize.put(player, Integer.parseInt(args[2]));
               messages.sendMessage("On your MasterTool the cube brush should now be equipd!");
           } else {
               messages.sendMessage("For brushes you just can use the BlazeRod as tool!");
           }

        }else if(args[1].equals("erode") || args[1].equals("e")) {
            if(player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
                edit.put(player, BrushTypes.ERODE_BRUSH);
                editSize.put(player, Integer.parseInt(args[2]));
                messages.sendMessage("On your MasterTool the erdoe brush should now be equipd!");
            } else {
                messages.sendMessage("For brushes you just can use the BlazeRod as tool!");
            }
        }
    }

    public String usage() {
        return "br <brush> <size>";
    }

    public String info() {
        return "command for brushes";
    }
}
