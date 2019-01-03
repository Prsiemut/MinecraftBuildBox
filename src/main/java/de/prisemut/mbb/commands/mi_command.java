package de.prisemut.mbb.commands;

import de.prisemut.mbb.debug.DebugManager;
import de.prisemut.mbb.interior.InteriorInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mi_command implements CommandInterface{


    public void run(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            Player player = (Player) sender;
            try {
                InteriorInventory.buildInventory(player);
            } catch (Exception e) {
                DebugManager.debug(player, "Error while open InteriorTool inventory: "+e.getMessage());
            }
        }
    }

    public String usage()
    {
        return "mi";
    }

    public String info() {
        return "Manuell interior tool!";
    }
}
