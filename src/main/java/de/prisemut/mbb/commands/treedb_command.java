package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class treedb_command implements CommandInterface{


    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Messages messages = new Messages(player);
        //treedb search [Name]
        //treedb filter [Biome] [Size]

        //treedb send [schematicname]
        //send is just temporary

        if (args[1].equals("filter") || args[1].equals("f")) {
            if(args.length >= 3 && args.length <= 4) {
                if(args.length == 3) {
                    /*
                    Filtering biome
                     */
                } else if(args.length == 4) {
                    /*
                    Filtering biome and size
                     */
                }
            } else {
                messages.sendMessage("treedb filter [Biome] (Size)");
            }
        } else if (args[1].equals("search") || args[1].equals("s")) {
            if(args.length == 3) {

            } else {
                messages.sendMessage("treedb search [Name | Keyword]");
            }
        } else if (args[1].equals("send")) {
            /*
            Send the schematic to TCP server!
             */
        }else{
            messages.sendMessage(usage());
        }


    }

    @Override
    public String usage() {
        return "treedb [filter | search]";
    }

    @Override
    public String info() {
        return "Useing treedatabse";
    }
}
