package de.prisemut.mbb.commands;

import de.prisemut.mbb.MinecraftBuildingBox;
import de.prisemut.mbb.debug.DebugManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class debug_command implements CommandInterface{


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length == 1) {
            if (DebugManager.debug.containsKey(player)) {
                DebugManager.finishDebug(player);
                player.sendMessage(MinecraftBuildingBox.prefix + "Finished debug, on our website or discord you can now receive support!");
            } else {
                player.sendMessage(MinecraftBuildingBox.prefix + "No problems are registerd in your list!");
            }
        } else {
            player.sendMessage(usage());
        }
    }

    @Override
    public String usage() {
        return "debug";
    }

    @Override
    public String info() {
        return "Command with more informations about your problem, for developers of the tool, you can receive support on discord or  on our website!";
    }
}
