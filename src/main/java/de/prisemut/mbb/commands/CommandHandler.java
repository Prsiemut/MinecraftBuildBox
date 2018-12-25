package de.prisemut.mbb.commands;

import de.prisemut.mbb.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class CommandHandler implements CommandExecutor {

    private static Hashtable<String, CommandInterface> registry = new Hashtable<String, CommandInterface>();
    private static ArrayList<String> registryList = new ArrayList<String>();
    private static Hashtable<String, String> usage = new Hashtable<String, String>();
    private static Hashtable<String, String> info = new Hashtable<String, String>();

    public CommandHandler(){
    }

    public void registerNewCommmand(String name, CommandInterface command) {
        registry.put(name, command);
        registryList.add(name);
        usage.put(name, getExecutor(name).usage());
        info.put(name, getExecutor(name).info());
    }

    public ArrayList<String> getRegistryList() {
        return registryList;
    }

    public CommandInterface getExecutor(String name) {
        return registry.get(name);
    }

    public boolean commandExisits(String worldname) {
        return registry.containsKey(worldname);
    }

    public String getInfo(String name) {
        return getExecutor(name).info();
    }


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player)commandSender;
        Messages m = new Messages(player);
        if(args.length <= 0 || args[0].equalsIgnoreCase("help")) {
            for(String commands : getRegistryList()) {
                m.sendMessage(" "+getInfo(commands) + " - "+getExecutor(commands).usage());
            }
        }
        return false;
    }
}
