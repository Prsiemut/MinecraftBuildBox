package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.brush.listener.BrushListener;
import de.prisemut.mbb.math.Cuboid;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fill_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);

        if(BrushListener.pos1.containsKey(player)) {
         if(BrushListener.pos2.containsKey(player)) {
             Cuboid cuboid = new Cuboid(BrushListener.pos1.get(player), BrushListener.pos2.get(player), player);
             cuboid.fillCube(Material.STONE);
         }else{
             messages.sendMessage("Please define Position 2!");
         }
        }else{
            messages.sendMessage("Please define Position 1!");
        }
    }

    public String usage() {
        return "fill <Material>";
    }

    public String info() {
        return "Fill your Cube!";
    }
}
