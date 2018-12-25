package de.prisemut.mbb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandInterface {

    void run(CommandSender sender, Command command, String label, String[] args);

    String usage();

    String info();

}
