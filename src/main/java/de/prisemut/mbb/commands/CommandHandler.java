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
    private static ArrayList<String> registrylist = new ArrayList<String>();
    private static Hashtable<String, String> descriptionmap = new Hashtable<String, String>();
    private static Hashtable<String, String> usagemap = new Hashtable<String, String>();
    private static Hashtable<String, String> permissions = new Hashtable<String, String>();

    public CommandHandler() {
    }

    public void registerNewCommand(String name, CommandInterface cmd) {
        registry.put(name, cmd);
        registrylist.add(name);

        descriptionmap.put(name, getExecutor(name).info());
        usagemap.put(name, getExecutor(name).usage());
    }

    public void setPermisson(String name, String permission) {
        permissions.put(name, permission);
    }

    public ArrayList<String> getRegistryList() {
        return registrylist;
    }

    public void setDescription(String name, String description) {
        descriptionmap.put(name, description);
    }

    public String getDescription(String name) {
        return getExecutor(name).info();
    }

    public void setUsage(String name, String usage) {
        usagemap.put(name, usage);
    }

    public String getUsage(String name) {
        return getExecutor(name).usage();
    }

    public boolean Commandexists(String name) {
        return registry.containsKey(name);
    }

    public CommandInterface getExecutor(String name) {
        return registry.get(name);
    }

    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

        if (args.length == 0 || args[0].equals("help") || !Commandexists(args[0])) {

            Player player;
            if (cs instanceof Player) {
                player = (Player) cs;

                Messages messages = new Messages(player);

                for (String command : getRegistryList()) {
                        messages.sendMessage("§7" + getUsage(command) + " - " + getDescription(command));
                }

                return true;
            } else {

                for (String command : getRegistryList()) {
                    cs.sendMessage("§7" + getUsage(command) + " - " + getDescription(command));
                }

                return true;
            }
        }

        getExecutor(args[0]).run(cs, cmd, label, args);

        return true;
    }
}
