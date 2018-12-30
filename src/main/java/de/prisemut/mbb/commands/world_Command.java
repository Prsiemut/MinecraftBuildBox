package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import de.prisemut.mbb.world.WorldManager;
import de.prisemut.mbb.world.WorldTypes;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class world_Command implements CommandInterface {


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);

        if(args[1].equals("create")){
            //mbb world create [Name] [Type] (l1) (l2)
            if(args.length >= 4 && args.length <= 6) {
                String worldname = args[2];
                WorldManager worldManager;
                if(args[3].equals("mf")) {
                    if(args.length == 4) {
                        worldManager = new WorldManager(worldname, WorldTypes.MF);
                        worldManager.createWorld();
                        messages.sendMessage("Created world " + args[2] + " successfully!");
                    } else {
                        messages.sendMessage("Please just use </mbb world create> [NAME] <mf>!");
                    }
                } else if (args[3].equals("mf+")) {
                    if(args.length == 4) {
                        worldManager = new WorldManager(worldname, WorldTypes.MFP);
                        worldManager.createWorld();
                        messages.sendMessage("Created world " + args[2] + " successfully!");
                    } else {
                        messages.sendMessage("Please just use </mbb world create> [NAME] <mf+>!");
                    }
                } else if (args[3].equals("flat")) {
                    if(args.length == 4) {
                        worldManager = new WorldManager(worldname, WorldTypes.FLAT);
                        worldManager.createWorld();
                        messages.sendMessage("Created world " + args[2] + " successfully!");
                    } else {
                      messages.sendMessage("Plese just use </mbb world create> [NAME] <flat>!");
                    }
                } else if (args[3].equals("cwc")) {
                    if(args.length == 6) {
                        //mbb world create [Name] [cwc] [l1] [l2]
                        worldManager = new WorldManager(worldname, Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                        worldManager.createCoustomWorld();
                        messages.sendMessage("Created world " + args[2] + " successfully!");
                    }else{
                        messages.sendMessage("Please just use </mbb world create> [NAME] <cwc> [LayerID 1] [LayerID 2]!");
                    }
                } else {
                    messages.sendMessage("All generators: [mf, mf+, flat, cwc]");
                }
            }
        } else if(args[1].equals("delete")) {
            if(args.length == 3) {
                WorldManager.deleteWorld(args[2]);
                messages.sendMessage(args[2] + " should now be deleted!");
            } else {
                messages.sendMessage("Please just use </mbb world delete> [NAME]!");
            }
        } else if(args[1].equals("list")) {
            if(args.length == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for(World world : Bukkit.getWorlds()) {
                    stringBuilder.append("§7"+world.getName() + ", ");
                }
                stringBuilder.setLength(stringBuilder.toString().length()-2);
                messages.sendMessage("List of all your worlds:");
                messages.sendMessage(stringBuilder.toString());
            } else {
                messages.sendMessage("Please just use </mbb world list>");
            }
        } else if (args[1].equals("tp") || args[1].equals("tele") || args[1].equals("teleport")) {
            if(args.length == 3) {
                try {
                    World world = Bukkit.getWorld(args[2]);
                    player.teleport(world.getSpawnLocation());
                    messages.sendMessage("Teleported to world " + args[2]);
                }catch (Exception e) {
                    messages.sendMessage("Can`t find this world!");
                }
            } else {
                messages.sendMessage("Please just use </mbb world tp/tele/teleport> [NAME]");
            }
        } else {
            messages.sendMessage(usage());
        }

    }

    @Override
    public String usage() {
        return "world [create | delete | list | tp/tele/teleport]";
    }

    @Override
    public String info() {
        return "For your projects!";
    }
}
